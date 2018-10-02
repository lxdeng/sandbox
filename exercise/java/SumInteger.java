

public class SumInteger {

	public static void main(String[] args) {
		
		int x = 1;
		int y = (~x)+1;
		System.out.println("y=" + y);
		
		Solution sol = new SumInteger().new Solution();
		
		System.out.println(sol.getSum2(2, 3));
		
	}

	class Solution {
	    public int getSum(int a, int b) {
	        int r = 0;
	        int carry = 0;
	        for (int i = 0; i < 32; i++) {
	            int aBit = (a >> i) & 1;
	            int bBit = (b >> i) & 1;
	            int sumBit = aBit ^ bBit;
	            boolean toCarry = ((aBit == 1 && bBit ==1) || (sumBit == 1 && carry ==1));
	                
	            sumBit ^= carry;
	            r |= sumBit << i;
	            
	            if (toCarry) 
	            	carry = 1;     
	            else
	            	carry = 0;
	            
	        }
	        return r;
	    }
	    
	    public int getSum2(int a, int b) {
	        if(a == 0) {
	            return b;
	        }
	        
	        if(b == 0) {
	            return a;
	        }
	        
	        int carry = 0;
	        
	        while(b != 0) {
	            
	            // If both bits are 1, we set the bit to the left (<<1) to 1 -- this is the carry step
	            carry = (a & b) << 1;
	            
	            // If both bits are 1, this will give us 0 (we will have a carry from the step above)
	            // If only 1 bit is 1, this will give us 1 (there is nothing to carry)
	            a = a ^ b;
	            
	            b = carry;
	        }
	        
	        return a;
	    }
	}
 
}