package org.example.files.storage.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.files.storage.File;
import org.example.files.storage.FileMetadata;
import org.example.files.storage.Storage;
import javax.sql.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SqlStorage implements Storage {

    private static final String STORE_FILE = "INSERT INTO files (id, size, content, labels) VALUES (?, ?, ?, ?)";

    private static final String GET_FILE_CONTENT = "SELECT content from files where id = ?";
    private static final String LOAD_FILES = "SELECT id, size, labels from files";

    private final DataSource dataSource;

    //label -> <FileMetadat1, FileMetadata2, FileMetadata3>
    private final HashMap<String, ArrayList<FileMetadata>> labelsMap = new HashMap<>();
    // id -> FileMetadata
    private final HashMap<String, FileMetadata> idMap = new HashMap<>();

    final private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    final private Lock writeLock = rwLock.writeLock();
    final private Lock readLock = rwLock.readLock();

    public SqlStorage() {
        this.dataSource = createDataSource();
        loadFiles(); // load all files metadata into memory, when starts up
    }

    @Override
    public FileMetadata store(String id, byte[] bytes, List<String> labels) {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement psmt = conn.prepareStatement(STORE_FILE)) {
            psmt.setString(1, id);
            psmt.setInt(2, bytes.length);
            psmt.setBytes(3, bytes);
            psmt.setArray(4, conn.createArrayOf("text", labels.toArray()));
            if (psmt.executeUpdate() != 1) {
                throw new RuntimeException("failed to store file");
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed to store file", e);
        }

        FileMetadata metadata = new FileMetadata(id, bytes.length, labels);

        writeLock.lock();
        addFileMetaData(metadata);
        writeLock.unlock();

        return metadata;
    }

    @Override
    public boolean fileExists(String id) {
        boolean exists;

        readLock.lock();
        try {
            exists = idMap.containsKey(id);
        } finally {
            readLock.unlock();
        }
        return exists;
    }

    @Override
    public File getFile(String id) {
        FileMetadata metadata = getFileMetadata(id);
        if (metadata == null) {
            return null;
        }

        byte[] content = getFileContent(id);
        return new File(metadata, content);
    }

    @Override
    public FileMetadata getFileMetadata(String id) {
        FileMetadata metadata;

        readLock.lock();
        try {
            metadata = idMap.get(id);
        } finally {
            readLock.unlock();
        }

        return metadata;
    }

    @Override
    public List<FileMetadata> searchFilesByLabel(String label) {
        List<FileMetadata> l = List.of();

        readLock.lock();
        try {
            if (labelsMap.containsKey(label)) {
                l = labelsMap.get(label);
            }
        } finally {
            readLock.unlock();
        }

        return l;
    }

    private byte[] getFileContent(String id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement psmt = conn.prepareStatement(GET_FILE_CONTENT)) {
            psmt.setString(1, id);

            try (ResultSet rset = psmt.executeQuery()) {
                if (rset.next()) {
                    return rset.getBytes(1);
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("failed to get file content", e);
        }
    }

    private void loadFiles() {
        System.out.println("Loading files from db");
        int count = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement psmt = conn.prepareStatement(LOAD_FILES)) {

            try (ResultSet rset = psmt.executeQuery()) {
                while (rset.next()) {
                    String id = rset.getString(1);
                    int size = rset.getInt(2);
                    Array labelsArray = rset.getArray(3);
                    String[] labels = (String[])labelsArray.getArray();
                    FileMetadata metadata = new FileMetadata(id, size, Arrays.asList(labels));
                    addFileMetaData(metadata);
                    ++count;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed to load files", e);
        }
        System.out.println(String.format("Totally loaded %s files", count));
    }
    
    private void addFileMetaData(FileMetadata metadata) {
        idMap.put(metadata.getID(), metadata);
        for (String l : metadata.getLabels()) {
            if (!labelsMap.containsKey(l)) {
                labelsMap.put(l, new ArrayList<>());
            }
            labelsMap.get(l).add(metadata);
        }
    }
    
    /*
    configuration does not work?
    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource createDataSource() {
        return DataSourceBuilder.create().build();
    }
    */

    public DataSource createDataSource() {
        String connectionString = "jdbc:postgresql://localhost:5432/filesdb";
        HikariConfig config = new HikariConfig();
        config.setUsername("filesuser");
        config.setPassword("welcome123");
        config.setJdbcUrl(connectionString);
        config.setMaximumPoolSize(10);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
}
