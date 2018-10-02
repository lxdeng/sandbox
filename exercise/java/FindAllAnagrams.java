import java.util.List;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;

public class FindAllAnagrams {
	public static void main(String[] args) {
		Solution sol = new FindAllAnagrams().new Solution();
		
		String p = "ab";
		String s = "abab";
		List<Integer> l = sol.findAnagrams(s, p);
		for (int x :l ) System.out.println(x);
		
	}
	
	public class Solution {
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> ret = new ArrayList<>();
	        char[] ss = s.toCharArray();
	        char[] pp = p.toCharArray();
	        int count = pp.length;
	        int[] counts = new int[256];
	        for (char c : pp) {
	            counts[c]++;
	        }
	        int i = 0;
	        for (int j = 0; j < ss.length; j++) {
	            if (counts[ss[j]] > 0) {
	                count--;
	            }
	            counts[ss[j]]--;
	            while (count == 0) {
	                if (j - i + 1 == pp.length) {
	                    ret.add(i);
	                }
	                counts[ss[i]]++;
	                if (counts[ss[i]] > 0) {
	                    count++;
	                }
	                i++;
	            }
	        }
	        return ret;
	    }
	}
	
	/*
	
	class Solution {
	    int LETTERS = 26; // lower case letters
	    
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list = new ArrayList<Integer>();
	        
	        if (s.length() < p.length()) return list;
	        
	        int [] countP = new int[LETTERS]; // counts of pattern
	        int [] countW = new int[LETTERS]; // counts of current window
	        
	        int len = p.length();
	        
	        for (int i = 0; i < len; i++) {
	            ++countP[p.charAt(i) - 'a'];
	            ++countW[s.charAt(i) - 'a'];    
	        }
	        
	        for (int i = len; i < s.length(); i++) {
	            if (compare(countP, countW)) 
	                list.add(i - len);
	            
	            // slide the window to right for one position
	            ++countW[s.charAt(i) -'a'];
	            --countW[s.charAt(i-len) - 'a'];
	        }   
	        
	        if (compare(countP, countW))
	        	list.add(s.length() - len);
	            
	        return list;
	    }
	    
	    boolean compare(int[] a, int[] b) {
	        for (int i = 0; i < LETTERS; i++)
	            if (a[i] != b[i]) return false;
	        
	        return true;
	    }
	}*/
	
	/*
	class Solution {
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> list = new ArrayList<Integer>();
	        HashSet<Character> set = new HashSet<>();
	        int pLen = p.length();
	            
	        char[] sArray = s.toCharArray();
	        char[] pArray = p.toCharArray();
	        Arrays.sort(pArray);
	        
	        for (char c: pArray)
	            set.add(c);
	        
	        char[] buf = new char[pLen];
	        
	        for (int i = 0; i <= sArray.length - pLen; i++) {
	            for (int j = 0; j < pLen; j++) {
	                if (!set.contains(sArray[i+j])) break;
	                if (j == pLen - 1) {
	                   System.arraycopy(sArray, i, buf, 0, pLen);
	                   Arrays.sort(buf);
	                   for (int k = 0; k < pLen; k++) {
	                       if (buf[k] != pArray[k]) 
	                    	   break;
	                       if (k == pLen - 1) 
	                    	   list.add(i);
	                   } 
	                }
	            }            
	        }
	        
	        return list;
	    }
	}*/
}
