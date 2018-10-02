//import java.util.Stack;

public class DecodeString {
	
	public static void main(String args[]) {
		String s = "100[leetcode]";
		String decoded = decodeString(s);
		System.out.println(decoded);
	}
	
	public static String decodeString(String s) {
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']')
               buf.append(c);
            else {
                int j;
                for (j = buf.length() - 1; j >= 0; j--)
                    if (buf.charAt(j) == '[') break;
                
                CharSequence repeated = buf.subSequence(j+1, buf.length());
                buf.setLength(j);    
                    
                for (j = buf.length() - 1; j >= 0; j--) {
                    char x = buf.charAt(j);
                    if (!(x >= '0' && x <= '9'))
                        break;
                }
                
                int count = 0;
                for (int k = j + 1; k < buf.length(); k++)
                    count = count * 10 + (buf.charAt(k) - '0');
                
                buf.setLength(j+1);
                
                for (int k = 0; k < count; k++)
                    buf.append(repeated);
            }//else
        }// for loop
        
        return new String(buf);
    }

	/*
	public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        //StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuffer repeated = new StringBuffer();
                char ch;
                while(true) {
                    ch = stack.pop();
                    if (ch == '[') {
                        break;
                    } else {
                        repeated.append(ch);
                    }
                }
                repeated.reverse();
                
                int count = 0;
                int sig = 1;
                while(!stack.empty()) {
                    ch = stack.peek();
                    if (ch >= '0' && ch <= '9') {
                        ch = stack.pop();
                        count = count + sig * (ch - '0');
                        sig *= 10;
                    } else 
                        break;
                }
                
                for (int j = 0; j < count; j++)
                    for (int k = 0; k < repeated.length(); k++)
                        stack.push(repeated.charAt(k));                
            }            
        } // for loop
            
        StringBuffer buf = new StringBuffer();
        while(!stack.empty()) {
            buf.append(stack.pop());
        }
        buf.reverse();
        return new String(buf);    
    }*/
	
        
}
