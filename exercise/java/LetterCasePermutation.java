import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public static void main(String args[]) {
		
		Solution sol = new LetterCasePermutation().new Solution();
		List<String> list = sol.letterCasePermutation("a1b2");
		System.out.println(list);		
	}
	
	
	class Solution {
	    public List<String> letterCasePermutation(String s) {
	        List<String> list = new ArrayList<>();
	        
	        permute(list, new StringBuffer(s), new StringBuffer());
	        return list;       
	    }
	    
	    void permute(List<String> list, StringBuffer s, StringBuffer buf) {
	        if (s.length() == 0) {
	            list.add(new String(buf));
	            return;
	        }

	        char x = s.charAt(0);
	        s.deleteCharAt(0);           
	           
	        if (Character.isDigit(x)) {
	            buf.append(x);  
	            permute(list, s, buf);                
	        } else if (Character.isLetter(x)) {
	            char y = Character.toLowerCase(x);
	            buf.append(y);               
	            permute(list, s, buf);
	                               
	            y = Character.toUpperCase(x);
	            buf.setCharAt(buf.length() - 1, y);
	            permute(list, s, buf);                
	        }
	            
	            //restore
	        buf.deleteCharAt(buf.length() - 1);
	        s.insert(0, x);
	    }
	}
}
