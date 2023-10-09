package org.example.files.storage;

import java.util.List;

/**
 * An interface for storing files with their metadata, and querying/retrieving files
 */

public interface Storage {
    /**
     * Stores a specified file and returns the stored File object
     * 
     * @param id the unique id of the file to be stored
     * @param bytes the byte array of the file's content
     * @param labels the list of labels where each is of the format "key:value" lowercased
     * @return the FileMetadata of the stored File object
     */
    public FileMetadata store(String id, byte[] bytes, List<String> labels);

    /**
     * Checks if a file exists by its ID
     * 
     * @param id the unique id of the file to be checked
     * @return true if the file has previously been stored and false if not
     */
    public boolean fileExists(String id);

    /**
     * Retrieves the File object with the specified id and null if it doesn't exist
     * 
     * @param id the unique id of the file to be retrieved
     * @return the retrieved File object or null if no such file exists
     */
    public File getFile(String id);

    /**
     * Retrieves the FileMetadata object with the specified id and null if it doesn't exist
     *
     * @param id the unique id of the file to be retrieved
     * @return the retrieved FileMetadata object or null if no such file exists
     */
    public FileMetadata getFileMetadata(String id);

    /**
     * Retrieves all files that contain the specified label
     * 
     * @param label string of format "key:value" to search for files with
     * @return List of FileMetadata that contain the specified label
     */
    public List<FileMetadata> searchFilesByLabel(String label);
}
