package lrucache;

import java.util.*;

public class LRUCache2 {

    private Map<Integer, Integer> map;

    public LRUCache2(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        map.put(key,value);
    }
}
