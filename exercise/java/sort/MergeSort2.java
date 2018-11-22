package sort;

public class MergeSort2 {
	public static void main(String args[]) {
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		mergesort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	static void mergesort(int[] nums) {
		int[] helper = new int[nums.length];
		
		mergesort(nums, helper, 0, nums.length - 1);		
	}
	
	static void mergesort(int[] nums, int[] helper, int low, int high) {
		if (low < high) {
			int middle = low + (high-low)/2;
			
			mergesort(nums, helper, low, middle);
			mergesort(nums, helper, middle+1, high);
			merge(nums, helper, low, middle, high);
		}
	}
	
	static void merge(int[] nums, int[] helper, int low, int middle, int high) {
		// copy into helper
		for (int i = low; i <= high; i++)
			helper[i] = nums[i];
		
		int helperLeft = low;
		int helperRight = middle+1;
		int current = low;
		
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				nums[current] = helper[helperLeft];
				helperLeft++;
			} else {
				nums[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++)
			nums[current + i] = helper[helperLeft + i];			
	}

}
