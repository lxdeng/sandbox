package org.example.files.storage;

import java.util.List;

public class File {
    final private byte[] content;
    final private FileMetadata metadata;

    public File(String id, byte[] content, List<String> labels) {
        this.content = content;
        metadata = new FileMetadata(id, content.length, labels);
    }

    public File(FileMetadata metadata, byte[] content) {
        this.metadata = metadata;
        this.content = content;
    }

    public byte[] getContent() {
        return this.content;
    }

    public FileMetadata getMetadata() {
        return this.metadata;
    }

    public String getID() {
        return metadata.getID();
    }
}