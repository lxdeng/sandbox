package knapsack;

import java.util.Arrays;

public class Solution {
	
	static int memo[][];
	
	public static void main(String[] args) {
		//int[] value = {7, 9, 5, 12, 14, 6, 12};
		//int[] size = {3, 4, 2, 6, 7, 3, 5};
		//int capacity = 15;
		
		int[] value = {1, 2, 5, 6};
		int[] size = {2, 3, 4, 5};
		int capacity = 8;
		
		
		//int[] value = {2,4};
		//int[] size = {1,2};
		//int capacity = 3;
		
		System.out.println(maxProfit(value, size, capacity));

		for (int[] a : memo) {
			for (int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	

	static int maxProfit(int[] value, int[] size, int capacity) {
		memo = new int[value.length][capacity+1];
		for (int[] a : memo)
			Arrays.fill(a, -1);
		
		return maxProfit(value.length, value, size, capacity);
	}
	
	
	static int maxProfit(int items, int[] value, int[] size, int cap) {
		if (items == 0) return 0;
		
		//System.out.println("items=" + items + " cap=" + cap);
		if (memo[items-1][cap] > -1) {
			//System.out.println("found cached " + ": items=" + items + " cap=" + cap);
			return memo[items-1][cap];
		}
		
		if (size[items - 1] > cap) // cannot be used
			return maxProfit(items - 1, value, size, cap);

		int r1 =  maxProfit(items - 1, value, size, cap); // don't use it
		int r2 = value[items - 1] + maxProfit(items - 1, value, size, cap - size[items-1]);		
		//System.out.println("items=" + items + " cap=" + cap + " r1=" + r1 + " r2=" + r2);
		memo[items-1][cap] = Math.max(r1,  r2);
		return memo[items-1][cap];
		//return Math.max(maxProfit(items - 1, value, size, cap), // don't use it
		//				value[items - 1] + maxProfit(items - 1, value, size, cap - size[items-1])); // use it
	}

}
