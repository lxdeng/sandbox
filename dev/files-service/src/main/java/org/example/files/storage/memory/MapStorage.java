package org.example.files.storage.memory;

import org.example.files.storage.File;
import org.example.files.storage.FileMetadata;
import org.example.files.storage.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapStorage implements Storage {
    private HashMap<String, ArrayList<FileMetadata>> labelsMap; //label -> <File1, File2, File3>
    private HashMap<String, File> idMap; // id -> File
    final private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    final private Lock writeLock = rwLock.writeLock();
    final private Lock readLock = rwLock.readLock();

    public MapStorage() {
        this.labelsMap = new HashMap<>();
        this.idMap = new HashMap<>();
    }

    public FileMetadata store(String id, byte[] bytes, List<String> labels) {
        File newFile;
        writeLock.lock();
 
        try {
            newFile = new File(id, bytes, labels);
            idMap.put(id, newFile);

            for (String l : labels) {
                if (!labelsMap.containsKey(l)) {
                    labelsMap.put(l, new ArrayList<>());
                }
                labelsMap.get(l).add(newFile.getMetadata());
            }
        } finally {
            writeLock.unlock();
        }

        return newFile.getMetadata();
    }

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

    public File getFile(String id) {
        File f = null;
        readLock.lock();
 
        try {
            if (idMap.containsKey(id)) {
                f = idMap.get(id);
            }
        } finally {
            readLock.unlock();
        }
        return f;
    }

    public FileMetadata getFileMetadata(String id) {
        File f = getFile(id);
        return f == null ? null : f.getMetadata();
    }

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
}