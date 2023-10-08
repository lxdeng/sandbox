package org.example.files;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FileDescriptorTest {
    
    @Test
    public void testConstructor() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("name=jack");
        labels.add("location=nyc");
        FileDescriptor fd = new FileDescriptor("1", 0, labels);

        assertEquals(fd.getID(), "1");
        assertEquals(fd.getSize(), 0);
        assertEquals(labels, fd.getLabels());
    }
}
