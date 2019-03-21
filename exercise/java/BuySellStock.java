
public class BuySellStock {
	public static void main(String args[]) {
		//int input[] = {7,1,5,3,6,4};
		int input[] = {7, 6, 5, 4, 3};
		int profit = maxProfit(input);
		System.out.println(profit);
	}
	
	public static int maxProfit(int[] prices) {      
       if (prices == null || prices.length < 2) return 0;
       
       int max = 0;
       int lowestPrice = prices[0];
       
       for (int i = 1; i < prices.length - 1; i++) {
    	   if (prices[i] < lowestPrice) {
    		   lowestPrice = prices[i];
    	   } else {
    		   int delta = prices[i] - lowestPrice;
    		   if (delta > max)
    			   max = delta;
    	   }
       }
       
       return max;
    }
	
}
