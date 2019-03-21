package validparenthesisstring;

public class Solution {
	
	public static void main(String[] args) {
		
		String s = "*(*()";
		System.out.println(new Solution().checkValidString(s));
	}
	
    public boolean checkValidString(String s) {
        return isValid(s.toCharArray(), 0, 0);
    }
    
    boolean isValid(char[] s, int start, int count) {
        for (int i = start; i < s.length; i++)
          switch(s[i]) {
            case '(':
                ++count;
                break;
            case ')':
                --count;
                if (count < 0) return false;
                break;
            case '*':
                // assume ' '
                if (isValid(s, i+1, count)) return true;
                    
                // assume '('
                if (isValid(s, i+1, count+1)) return true;
                    
                // assume ')'
                if (count == 0) return false;
                if (isValid(s, i+1, count-1)) return true;
                    
                return false;
          } // end of switch
        
        return count == 0;
    }
}
