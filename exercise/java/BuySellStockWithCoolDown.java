import java.util.*;

public class BuySellStockWithCoolDown {
	public static void main(String args[]) {
		//int input[] = {7,1,5,3,6,4};
		int input[] = {1, 2, 3, 0, 2};
		
	
		int profit = new BuySellStockWithCoolDown().maxProfit(input);
		System.out.println(profit);
		
		
		ArrayList<? super Integer> x = new ArrayList<Number>();
		x.add(new Integer(0));
		Object y = x.get(0);
	}
	
	public int maxProfit(int[] prices) {
        return maxProfit(prices, 0);
    }
    
    // brute force
    int maxProfit(int[] prices, int start) {
        if (start >= prices.length - 1) return 0;
        
        int max = 0;
        int profit;
        // buy on the start day
        System.out.println("buy on day " + start);
        
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i] > prices[start]) {
                System.out.println("sell on day " + i);
                profit = prices[i] - prices[start];
                profit += maxProfit(prices, i + 2); // sell on day i, cool down on day i + 1
                if (profit > max)
                    max = profit;
            }
        }
        
        // skip the start day
        profit = maxProfit(prices, start + 1);
        if (profit > max)
            max = profit;
        
        return max;
    }
	
}
