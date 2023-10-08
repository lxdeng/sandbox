package org.example.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class File {
    final private String id;
    final private byte[] contents;
    final private FileMetadata metadata;

    public File(String id, byte[] contents, List<String> labels) {
        this.id = id;
        this.contents = contents;
        metadata = new FileMetadata(contents.length, labels);
    }

    public byte[] getContents() {
        return this.contents;
    }

    public FileMetadata getMetadata() {
        return this.metadata;
    }

    public String getID() {
        return id;
    }
}