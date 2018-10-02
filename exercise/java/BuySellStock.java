
public class BuySellStock {
	public static void main(String args[]) {
		int input[] = {7,1,5,3,6,4};

		int profit = maxProfit(input);
		System.out.println(profit);
	}
	
	public static int maxProfit(int[] prices) {      
        if (prices == null || prices.length <= 1) return 0;
        
        int min = prices[0];
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
               if (prices[i] - min > max)
                  max = prices[i] - min;            
        }

        return max;
    }
	
}
