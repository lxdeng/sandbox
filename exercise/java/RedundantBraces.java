import java.util.*;

public class RedundantBraces {
	public static void main(String args[]) {
		RedundantBraces test = new RedundantBraces();
		
		String s = "(a*c)*a";
		
		System.out.println(test.checkRedundancy(s));
		System.out.println(test.checkRedundancy2(s));
	}
	
	boolean checkRedundancy(String s) { 
        // create a stack of characters  
        Deque<Character> st = new LinkedList<>(); 
        char[] str = s.toCharArray(); 
        // Iterate through the given expression  
        for (char ch : str) { 
  
            // if current character is close parenthesis ')'  
            if (ch == ')') { 
                char top = st.pop(); 
  
                // If immediate pop have open parenthesis '('  
                // duplicate brackets found  
                boolean flag = true; 
  
                while (top != '(') { 
  
                    // Check for operators in expression  
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') { 
                        flag = false; 
                    } 
  
                    // Fetch top element of stack  
                    top = st.pop(); 
                } 
  
                // If operators not found  
                if (flag == true) { 
                    return true; 
                } 
            } else { 
                st.push(ch); // push open parenthesis '(',  
            }                // operators and operands to stack  
        } 
        return false; 
	}
	
	boolean checkRedundancy2(String s) { 
		Deque<Integer> st = new LinkedList<>(); 
        st.push(0);
        
		char[] str = s.toCharArray(); 
        // Iterate through the given expression  
        for (char c : str) { 
        	if (c == '(') {
        		st.push(0);
        	} else if (c == ')') {
        		if (st.pop() == 0)
        			return true;
        	} else {
        		st.push(st.pop()+1);
        	}	
        }
		
        return st.pop() == 0;
	}
}
