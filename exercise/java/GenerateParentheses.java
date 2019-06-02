import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {

public static void main(String[] args) {
		
		Solution sol = new GenerateParentheses().new Solution();
		List<String> l = sol.generateParenthesis(3);
		System.out.println(l);
	}

class Solution {
	
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        search(list, 2 * n, "");
        return list;
    }
    
    void search(List<String> list, int count, String chosen) {
        if (count == 0) {
            if (valid(chosen))
                list.add(chosen);
        }
        
        search(list, count - 1, chosen + "(");
        search(list, count - 1, chosen + ")");  
    }
    
    boolean valid(String s) {
        int balance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else
                balance--;
            
            if (balance < 0)
                return false;
        }
        
        return balance == 0;
    }
	
	
	
	/*
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        
        if (n < 1) return list;
        
        StringBuffer result = new StringBuffer();
    
        permute(list, 2*n, result, n, 0, 0);
        
        return list;
    }
    
    // countL: count of (
    // countR: count of )
    void permute(List<String> list, int positions, StringBuffer result, int count, int countL, int countR) {
        //anytime, number of ) cannot excceed countL
        if (countR > count || countL > count || countR > countL)
            return;
        
        if (positions == 0) {
            //if (isValid(result))
            list.add(new String(result));
            return;
        }
        
        result.append('(');
        countL++;
        permute(list, positions - 1, result, count, countL, countR);           
        result.deleteCharAt(result.length() - 1);
        countL--;
            
        result.append(')');
        countR++;
        permute(list, positions - 1, result, count, countL, countR);     
        result.deleteCharAt(result.length() - 1);
        countR--;       
    }
    
    boolean isValid(StringBuffer s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.empty())
                    return false;
                
                char c = stack.pop();
                if (c != '(')
                    return false;               
            }
                
        }
        
        return stack.empty();
    }
    */
}

}
