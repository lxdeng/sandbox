package org.example.files.storage;

import java.util.List;

public class FileMetadata {
    final private String id;
    final private long size;
    final private List<String> labels;

    public FileMetadata(String id, long size, List<String> labels) {
        this.id = id;
        this.size = size;
        this.labels = labels;
    }

    public String getID() {
        return id;
    }

    public long getSize() {
        return size;
    }

    public List<String> getLabels() {
        return labels;
    }

    public static boolean validLabel(String label) { //"name:kelly"
        String[] splitted = label.split(":");
        return splitted.length == 2; // ["name", "kelly"]
    }
}