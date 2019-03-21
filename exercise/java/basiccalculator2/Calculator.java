package basiccalculator2;

public class Calculator {
	public static void main(String args[]) {
		Solution sol = new Solution();
		
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(myAtoi("-2147483648"));
		//System.out.println(sol.calculate("1+ 2  *3"));
	}
	
    public static int myAtoi(String str) {
        if (str == null) return 0;
        
        char[] a = str.toCharArray();
        int index = 0;
        
        while (index < a.length && a[index] == ' ') index++;
        
        if (index == a.length) return 0;
        
        boolean neg = false;
        if (a[index] == '+') {
            ++index;     
        } else {
            if (a[index] == '-') {
               neg = true;    
               ++index;
            }
        }
            
        if (index == a.length || a[index] > '9' || a[index] < '0') return 0;
            
        long r = 0;
            
        while(index < a.length && a[index] >= '0' && a[index] <= '9') {
            r = r * 10 + a[index++] - '0';

            if (neg)
                if (-r < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else
                if (r > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
            
        if (neg)
            return -(int)r;
        else
            return (int)r;
        
    }
	
}
