package org.example.files;

import java.util.List;

public class FileMetadata {
    final private long size;
    final private List<String> labels;

    public FileMetadata(long size, List<String> labels) {
        this.size = size;
        this.labels = labels;
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