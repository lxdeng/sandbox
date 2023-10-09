package org.example.files;

import org.example.files.storage.FileMetadata;

import java.util.List;

public class FileDescriptor extends FileMetadata {

    public FileDescriptor(String id, long size, List<String> labels) {
        super(id, size, labels);
    }

    public FileDescriptor(FileMetadata fileMetadata) {
        super(fileMetadata.getID(), fileMetadata.getSize(), fileMetadata.getLabels());
    }
}