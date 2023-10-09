package org.example.files.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.example.files.storage.FileMetadata;
import org.junit.jupiter.api.Test;

public class FileMetadataTest {

    @Test
    public void testConstructor() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("name=jack");
        labels.add("location=nyc");

        FileMetadata fmd = new FileMetadata("id1", 0, labels);
        assertEquals(fmd.getID(), "id1");
        assertEquals(fmd.getSize(), Long.valueOf(0));
        assertEquals(fmd.getLabels(), labels);
    }

    @Test
    public void testValidLabel() {
        assertEquals(true, FileMetadata.validLabel("name:kelly"));
        assertEquals(false, FileMetadata.validLabel("name::kelly"));
        assertEquals(false, FileMetadata.validLabel("name"));
        assertEquals(false, FileMetadata.validLabel(""));
        assertEquals(false, FileMetadata.validLabel(" "));
    }
}
