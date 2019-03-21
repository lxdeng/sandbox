package permutationinstring;

public class Solution {
	public static void main(String[] args) {
		
		String s1 = "adc";
		String s2 =	"dcda";
		
		System.out.println(new Solution().checkInclusion(s1, s2));
		
	}

	 public boolean checkInclusion(String s1, String s2) {
	        if (s1.length() > s2.length()) return false;
	        
	        char a1[] = s1.toCharArray();
	        int tab1[] = new int[26];
	        char a2[] = s2.toCharArray();
	        int tab2[] = new int[26];
	        
	        for (int i = 0; i < a1.length; i++) {
	            tab1[a1[i] - 'a']++;
	            tab2[a2[i] - 'a']++;
	        }    

	        for (int i = 0; i < a2.length - a1.length; i++) {
	            if (match(tab1, tab2))
	                return true;
	            
	            tab2[a2[i] - 'a']--;
	            tab2[a2[i+a1.length] - 'a']++;
	        }
	        
	        return match(tab1, tab2);
	    }
	    
	    private boolean match(int[] tab1, int[] tab2) {
	        for (int i = 0; i < 26; i++)
	            if (tab1[i] != tab2[i]) return false;
	        
	        return true;
	    }
}
