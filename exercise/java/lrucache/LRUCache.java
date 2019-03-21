package lrucache;

import java.util.*;

public class LRUCache {
	
	public static void main(String[] args ) {
		/*
		 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		 */
		
		/*
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		*/
		
		/*
		LRUCache cache = new LRUCache(2);
		
		System.out.println(cache.get(2));
		cache.put(2, 6);
		System.out.println(cache.get(1));
		
		cache.put(1, 5);
		cache.put(1, 2);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		*/
		
		/*
		LRUCache cache = new LRUCache(2);

		cache.put(2, 1);
		cache.put(2, 2);
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));
		*/
		
		//["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
		//		[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
		
		
		LRUCache cache = new LRUCache(1);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		
		cache.put(5, 5);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
		
	}

	HashMap<Integer, Entry> map;
    int capacity;
    Entry dummyHead;
    Entry tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Entry(0, 0);
        tail = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Entry ent = map.get(key);
        
        //move the entry to the end of the doubly linked list
        if (ent.next != null) {
            //System.out.println("to move entry to the end " + ent.key);
            ent.next.prev = ent.prev;
            ent.prev.next = ent.next;

            tail.next = ent;
            ent.prev = tail;
            ent.next = null;
            tail = tail.next;
            
        }
    
        return ent.value;
    }
    
    public void put(int key, int value) {
    	if (capacity <= 0) return;
    	
    	if (map.containsKey(key)) {
            Entry ent = map.remove(key);
            
            if (ent.next != null) {
                ent.next.prev = ent.prev;
                ent.prev.next = ent.next;
            } else {
            	tail = ent.prev;
                ent.prev.next = null;
            }
        }
    	
        if (map.size() == capacity) { // evict
            //System.out.println("to evict " + dummyHead.next.key);
            map.remove(dummyHead.next.key);
            dummyHead.next = dummyHead.next.next;
            if (dummyHead.next != null)
               dummyHead.next.prev = dummyHead; 
            
            if (capacity == 1)
            	tail = dummyHead;
        }   
        
        Entry ent = new Entry(key, value);
        map.put(key, ent);
            
        // record as the end of the doubly linked list
        tail.next = ent;
        ent.prev = tail;
        tail = tail.next;
    }
}

class Entry {
    Entry prev;
    Entry next;
    Integer key;
    int value;
    
    public Entry(int k, int v) {
        key = new Integer(k);
        value = v;
    }
}
