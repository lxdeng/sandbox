package sort;

import java.util.Random;


public class QuickSort {
	static Random rand = new Random();

	public static void main(String args[]) {
		//for (int i = 0; i < 100; i++) 
		//	System.out.println(getRandom(0, 100));
		
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
			
	}
	
	static void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	static void quickSort(int[] nums, int start, int end) {
		if (start >= end) return;
		
		int pIndex = partition(nums, start, end);
		//int pIndex = randomizedPartition(nums, start, end);
		quickSort(nums, 0, pIndex - 1);
		quickSort(nums, pIndex + 1, end);	
	}
	
	static int getRandom(int start, int end) {	
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((end - start) + 1) + start;

	    return randomNum;
	}
	
	static int randomizedPartition(int[] nums, int start, int end) {
		int r = getRandom(start, end);
		
		int temp = nums[end];
		nums[end] = nums[r];
		nums[r] = temp;
		
		return partition(nums, start, end);
		
	}
	
	static int partition(int[] nums, int start, int end) {
		int pivotal = nums[end];
		
		int pIndex = 0;		

		for (int i = 0; i < end; i++) {
			if (nums[i] <= pivotal) {
				if (pIndex != i) {
					int temp = nums[i];
					nums[i] = nums[pIndex];
					nums[pIndex] = temp;
				}
					
				pIndex = pIndex + 1;	
			}
		}
		
		nums[end] = nums[pIndex];
		nums[pIndex] = pivotal;
			
		return pIndex;
	}
}

