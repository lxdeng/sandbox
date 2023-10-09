package org.example.files.storage;

import org.example.files.storage.FileMetadata;

import java.util.List;

public class File {
    final private byte[] contents;
    final private FileMetadata metadata;

    public File(String id, byte[] contents, List<String> labels) {
        this.contents = contents;
        metadata = new FileMetadata(id, contents.length, labels);
    }

    public byte[] getContents() {
        return this.contents;
    }

    public FileMetadata getMetadata() {
        return this.metadata;
    }

    public String getID() {
        return metadata.getID();
    }
}