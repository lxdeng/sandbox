package kthelargest;

import java.util.*;

class KthLargest {
	final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        System.out.println(q.size());
        
        for (int n : a)
            add(n);
        System.out.println(q.size());
    }

    public int add(int n) {
    	 System.out.println(q.size());
    	 
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
    
    public static void main(String[] args) {
    	
    	int[] nums = {4,5,8,2};
    	KthLargest klg = new KthLargest(3, nums);
    	
    	System.out.println(klg.add(3));
    	
    	System.out.println(klg.add(5));

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */