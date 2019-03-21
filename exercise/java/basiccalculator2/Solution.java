package basiccalculator2;

import java.util.Stack;

class Solution {

    

        public static final int PLUS = -1;
        public static final int SUB = -2;
        public static final int MUL = -3;
        public static final int DIV = -4;
        public static final int OP_NONE = 100;
        
        public int calculate(String s) {
            
            Stack<Integer> operand = new Stack<>();
            
            MyTokenizer st = new MyTokenizer(s);

            int op = OP_NONE;
            
            while (st.hasMoreTokens()) {
                int token = st.nextToken();
                
                if (token == Solution.PLUS || token == Solution.SUB) {
                    if (op == OP_NONE)
                        op = token;
                    else {
                        int op2 = operand.pop();
                    	int op1 = operand.pop();

                    	operand.push(eval(op1, op2, op));
                    	operand.push(st.nextToken());
                        op = token;
                    }
                } else if (token == Solution.MUL || token == Solution.DIV) {
                    int op2 = st.nextToken();
                    operand.push(eval(operand.pop(), op2, token));
                } else {
                    operand.push(token);
                }
                
            }
                    
            if (op != OP_NONE) {
            	int op2 = operand.pop();
            	int op1 = operand.pop();
            	
            	return eval(op1, op2, op);
            }
            else
            	return operand.pop();
            
        }
        
        int eval(int op1, int op2, int op) {
            if (op == Solution.PLUS)
                return op1 + op2;
            
            if (op == Solution.SUB)
                return op1 - op2;
            
            if (op == Solution.MUL)
                return op1 * op2;

            return op1 / op2;
        }

    }

    class MyTokenizer {
        
        int index;
        char[] buf;
        int len;
            
        MyTokenizer(String s) {
            buf = s.toCharArray();
            len = buf.length;
        }
        
        boolean hasMoreTokens() {
            while (index < len && buf[index] == ' ') index++;
            
            return index < len;
        }
        
        int nextToken() {
            while (index < len && buf[index] == ' ') index++;
            
            if (buf[index] == '+') {
                index++;
                return Solution.PLUS;
            }
                
            if (buf[index] == '-') {
                index++;
                return Solution.SUB;
            }
            
            if (buf[index] == '*') {
                index++;
                return Solution.MUL;
            }
            
            if (buf[index] == '/') {
                index++;
                return Solution.DIV;
            }

            
            int start = index;
            while (index < len && buf[index] <= '9' &&buf[index] >= '0') index++;
            
            return Integer.parseInt(new String(buf, start, index - start));
        }
        
    }
