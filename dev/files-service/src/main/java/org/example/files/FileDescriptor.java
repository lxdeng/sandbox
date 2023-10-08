package org.example.files;

import java.util.List;

public class FileDescriptor extends FileMetadata {
    final private String id;

    public FileDescriptor(String id, long size, List<String> labels) {
        super(size, labels);
        this.id = id;
    }

    public String getID() {
        return id;
    }
}