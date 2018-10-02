
public class ReserseBits {

	
	public static void main(String[] args) {
				
	    int n = 43261596;
		//int n = -1;

		System.out.println(reverseBits2(n));
		
	}
	
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        long nn = n;
        
        int bits[] = new int[32];
        
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            int t = (int) (nn & mask);
            t >>= i;
            bits[i] = t;
            
            mask *= 2;
        }
        
        //for(int x: bits) {
        //	System.out.println(x);
        //}
        
        for (int i = 0; i < 16; i++) {
            int temp = bits[31-i];
            bits[31-i] = bits[i];
            bits[i] = temp;
        }
        
        int r = 0;
        for (int i = 31; i >=0; i--) {
            r = r*2 + bits[i];
        }
        
        return r;
    }
    
    public static int reverseBits2(int n) {
    	int r = 0;
    	for (int i = 0; i < 32; i++) {
    		int bit = (n >>> i) & 1;
    		r = r*2 + bit;
    		
    	}
    	return r;
    	
    }
}