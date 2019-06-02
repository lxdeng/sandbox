package coinchange;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[] coins = {186,419,83,408};

		System.out.println(new Solution().coinChange(coins, 6249));
	}
	
	 int memo[];
	    
	    public int coinChange(int[] coins, int amount) {
	        memo = new int[amount+1];
	        return change(coins, amount);    
	    }
	    
	    int change(int[] coins, int amount) {
	        if (amount == 0) return 0;
	        if (amount < 0) return -1;
	        
	        if (memo[amount] > 0) return memo[amount];
	        
	        int r = Integer.MAX_VALUE;
	        for (int coin : coins) {
	            int x = change(coins, amount - coin);
	            if (x >= 0)
	                r = Math.min(r, x + 1);
	        }
	        
	        memo[amount] = (r == Integer.MAX_VALUE ? -1 : r);
	        return memo[amount];
	    }
}