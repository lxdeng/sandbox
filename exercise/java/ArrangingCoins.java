
public class ArrangingCoins {

	public static void main(String[] args ) {
	
		System.out.println(arrangeCoins(72));
	}
	
	public static int arrangeCoins(int n) {   
        
        int start = 0;
        int end = n;
        long nn = 2 * (long)n;
        
        while (start <= end) {
            int middle = start + (end-start)/2;
            long x = (long)middle * (middle + 1);
            if (x == nn)
                return middle;
            
            if (x > nn)
                end = middle-1;
            else
                start = middle+1;
        }

        return start-1;
    }

}
