package mostkfrequent;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {3, 0, 1, 0};
		List<Integer> list = new Solution().topKFrequent(nums, 1);
		
		for (int x : list)
			System.out.println(x);
		
	}
	
    public List<Integer> topKFrequent(int[] nums, int k) {        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);    
        }
        
        System.out.println(map.size());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for (int key : map.keySet()) {            
            if (minHeap.size() < k) {
                minHeap.offer(key);
            } else {
                int cnt = map.get(key);
                if (cnt > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }
        
        
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) 
            res.add(minHeap.poll());
        
        return res;
    }
}