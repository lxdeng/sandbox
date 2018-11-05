public class MyHashSet {

    private final int NUM_BUCKETS = 10000;
    
    private Bucket buckets[];
    
    
    public static void main(String args[]) {
    	MyHashSet set = new MyHashSet();
    	
    	set.add(1);
    	set.add(2);
    	
    	set.contains(1);
    	set.contains(3);
    	
    	set.add(2);
    	set.contains(2);
    	
    	set.remove(2);
    	set.contains(2);
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new Bucket[NUM_BUCKETS];    
    }
    
    public void add(int key) {
       
        if (!contains(key)) {
            int index = key % NUM_BUCKETS;
            if (buckets[index] == null)
                buckets[index] = new Bucket();
            
            Node node = new Node(key);
            node.next = buckets[index].head;
            buckets[index].head = node;
        }
        
        
    }
    
    public void remove(int key) {
        int index = hashFunction(key);
        Bucket bucket = buckets[index];
        
        if (bucket == null) return;
        
        Node pre = null;
        Node current = bucket.head;
        
        while (current != null) {
            if (current.key == key) {
                if (pre == null) {
                    bucket.head = current.next;
                } else {
                    pre.next = current.next;
                }               
            } else {
                pre = current;
                current = current.next;
            }               
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hashFunction(key);
        
        Bucket bucket = buckets[index];
        
        if (bucket == null)
            return false;
        
        Node current = bucket.head;
        while (current != null) {
            if (current.key == key)
                return true;
            else
                current = current.next;
        }
        return false;
    }
    
    private int hashFunction(int key) {
        return key % NUM_BUCKETS;
    }
}

class Bucket {
    Node head; 
}

class Node {
    int key;
    Node next;
    
    Node(int k) {
        key = k;
    }
}

    