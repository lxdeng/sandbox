package strstr;


public class Solution {
	
	 public static void main(String[] args) {
	    	
	    	Solution sol = new Solution();
	    	System.out.println(sol.strStr("mississippi",  "mississippi"));

	 }
	 
	 public int strStr(String haystack, String needle) {
	        if (needle.length() == 0) return 0;

	        char[] hay = haystack.toCharArray();
	        char[] n = needle.toCharArray();
	        
	 search:
	        for (int i = 0; i <= hay.length - n.length; i++) {
	            for (int j = 0; j < n.length; j++) {
	                if (hay[i+j] != n[j])
	                    continue search;
	            }
	            return i;
	        }
	        
	        return -1;
	    }

}
