package org.example.files.storage.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.files.storage.File;
import java.util.ArrayList;

import org.example.files.storage.FileMetadata;
import org.junit.jupiter.api.Test;

public class MapStorageTest {

    @Test
    public void testStore() {
        MapStorage storage = new MapStorage();

        ArrayList<String> labels = new ArrayList<>();
        labels.add("name:jack");
        labels.add("location:nyc");
        storage.store("1", new byte[0], labels);

        FileMetadata jackFile = storage.searchFilesByLabel("name:jack").get(0);
        FileMetadata nycFile = storage.searchFilesByLabel("location:nyc").get(0);
        
        assertEquals(storage.searchFilesByLabel("name:jack").size(), 1);
        assertEquals(storage.searchFilesByLabel("location:nyc").size(), 1);
        assertEquals(jackFile, nycFile);
    }

    @Test
    public void testFileExists() {
        MapStorage storage = new MapStorage();

        ArrayList<String> labels = new ArrayList<>();
        labels.add("name:jack");
        storage.store("1", new byte[0], labels);

        assertTrue(storage.fileExists("1"));
        assertFalse(storage.fileExists("2"));
    }

    @Test
    public void testGetFilesByLabel() {
        MapStorage storage = new MapStorage();

        assertEquals(storage.searchFilesByLabel("location:nyc"), new ArrayList<FileMetadata>());

        ArrayList<String> labels = new ArrayList<>();
        labels.add("name:jack");
        labels.add("location:nyc");
        FileMetadata f = storage.store("1", new byte[0], labels);

        assertEquals(storage.searchFilesByLabel("name:jack").get(0), f);
        assertEquals(storage.searchFilesByLabel("location:nyc").get(0), f);
    }
}
