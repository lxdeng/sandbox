package knapsack;

import java.util.Arrays;

public class Solution2 {
	
	boolean used[];
	int maxProfit;
	
	public static void main(String[] args) {
		int[] value = {7, 9, 5, 12, 14, 6, 12};
		int[] size = {3, 4, 2, 6, 7, 3, 5};
		int capacity = 15;
		
		//int[] value = {2,4};
		//int[] size = {1,2};
		//int capacity = 3;
		
		Solution2 sol = new Solution2();
		
		System.out.println(sol.maxProfit(value, size, capacity));
		//printItems(value.length, 15);
		
	}
	
	void printItems(int items, int cap) {
		/*
		for (int i = 0; i < items-1; i++) {
			if (memo[i][cap] != memo[i+1][cap])
				System.out.println("item " + (i+1) + " used");
		}*/
		
		for (int i = 0; i < items; i++) {
			//System.out.println(memo[i][cap]);
		}
	}

	int maxProfit(int[] value, int[] size, int capacity) {
		used = new boolean[value.length];
		
		search(0, value, size, capacity);
		
		return maxProfit;
	}
	
	void search (int start, int[] value, int[] size, int cap) {
		
		if (start == value.length) {
			int totalValue = 0;
			for (int i = 0; i < value.length; i++) {
				if (used[i])
					totalValue += value[i];
			}
			
			if (totalValue > maxProfit) {
				maxProfit = totalValue;
				System.out.print(totalValue);
				for (int i = 0; i < value.length; i++) 
					System.out.print(" " + (used[i] ? 1 : 0));
				System.out.println();
			} else {
				for (int i = 0; i < value.length; i++) 
				System.out.print(" " + (used[i] ? 1 : 0));
				System.out.println();
			}
		
		}
		
		for(int i = start; i < value.length; i++) {
			if (size[i] <= cap) {
				used[i] = true;
				search (i + 1, value, size, cap - size[i]);
				used[i] = false;
			} else {
				search (i + 1, value, size, cap);
			}
		}
	}		
			

}
