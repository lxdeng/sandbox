package substringconcat;

import java.util.*;


public class Solution {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		//String s = "barfoofoobarthefoobarman";
		//String []words = {"bar","foo","the"};
		
		//String s = "wordgoodgoodgoodbestword";
		//String[] words = {"word","good","best","word"};
		
				
		//String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		//String[] words = {"fooo","barr","wing","ding","wing"};
		
		//String s = "aaa";
		//String[] words = {"a","b"};
		
		//String s = "barfoothefoobarman";
		//String[] words = {"foo","bar"};
		
		String s = "aaaaaaaa";
		String[] words = {"aa","aa","aa"};
				
		List<Integer> list = sol.findSubstring(s, words);
		
		for (int n : list)
			System.out.println(n);
	}
	
	public List<Integer> findSubstring(String s, String[] words) {
        // this problem is similar to the find all the anagrams problem
        // use HashMap and Sliding Window
        
        ArrayList<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;

        HashMap<String, Integer> map = new HashMap<>();
        
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);
        
        int size = words.length;
        int len = words[0].length();
        
        for (int i = 0; i < len; i++)
            search(s, i, map, len, size, list);
        
        return list;
    }
    
    void search(String str, int start, HashMap<String, Integer> map, int len, int size, ArrayList<Integer> list) {
        int left = start, right = start;
        int count = size;
        
        int temp;
        String sub;
        while (right < str.length() - len + 1) {
            sub = str.substring(right, right + len);
            if (map.containsKey(sub)) {
                temp = map.get(sub);
                if (temp > 0) // only great than 0, decrease the counter
                    count--;
                map.put(sub, temp - 1);
            }
            right += len; // move the right to expand the window
            
            if (count == 0)
                list.add(left);
            
            if (right - left == len * size) { // window reaches the max size, ready to move left
                sub = str.substring(left, left + len);
                if (map.containsKey(sub)) {
                    temp = map.get(sub);
                    if (temp >= 0)
                        count++;
                    map.put(sub, temp + 1); // restore the count reduced by the right pointer
                }
                left += len;
            }
        } // end of while-loop
        
    }
	
    public List<Integer> findSubstring2(String s, String[] words) { 
        // similar to the problem "Find All Anagrams in a String". See its solution commented bellow

        
        final List<Integer> indexes = new ArrayList<>();
        
        if (words == null || words.length == 0 || words[0].length() == 0) return indexes;
        
        if (s.length() < words[0].length() * words.length) return indexes;
        
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words)
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        
        int n = s.length(), 
            num = words.length, 
            len = words[0].length();
        
        Map<String, Integer> seen = new HashMap<>();
        int i = 0;
        while (i < n - num * len + 1) {
            seen.clear();
            
            for (int j = 0; j < num; j++) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (!counts.containsKey(word)) { // we can skip some (j words) to start after the j
                    i += j * len;
                    break;
                }
                
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > counts.get(word)) {
                    // we can only advance one word
                    break;
                }
                
                if (j == num-1) {
                    indexes.add(i); // found one, and then advance one word
                }
            }
            
            i++;
        }

        return indexes;
    } 
	
}