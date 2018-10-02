import java.util.List;

import java.util.HashSet;

//import java.util.ArrayList;
import java.util.Arrays;

public class WorkBreak {

	public static void main(String[] args) {
		Solution sol = new WorkBreak().new Solution();
		
		String s = "leetcode";
		
		String[] words = {"leet", "code"};
		
		List<String> dict = Arrays.asList(words);
		
		System.out.println(sol.wordBreak(s, dict));
		
	}
	
	class Solution {
		
		public boolean wordBreak(String s, List<String> wordDict) {
			
			HashSet<String> dict = new HashSet<>();
	        for (String word : wordDict)
	            dict.add(word);
			
	        int n = s.length();
	        
	        // b[i] represents whether s[0...i] can be formed by dict
	        boolean[] b = new boolean[n];
	        
	        for (int i = 0; i < n; i++) {
	          for (int j = 0; j <= i; j++) {
	            String sub = s.substring(j, i + 1);
	            
	            if (dict.contains(sub) && (j == 0 || b[j - 1])) {
	              b[i] = true;
	              break;
	            }
	          }
	        }
	        
	        return b[n-1];		
			
		}
		
		
		/*
	    public boolean wordBreak(String s, List<String> wordDict) {

	        HashSet<String> set = new HashSet<>();
	        for (String word : wordDict)
	            set.add(word);
	        
	        return wordBreak(s, 0, set);
	    }
	    
	    boolean wordBreak(String s, int pos, HashSet<String> set) {
	        if (pos + 1 == s.length())
	            return set.contains(s.substring(pos));
	            
	        for (int i = pos + 1; i < s.length(); i++) {
	            String s1 = s.substring(pos, i);
	            if (set.contains(s1)) {
	                if (wordBreak(s, i, set))
	                	return true; 
	            }    
	        }
	        
	        return set.contains(s.substring(pos));
	    }*/
		
	}
	
}
