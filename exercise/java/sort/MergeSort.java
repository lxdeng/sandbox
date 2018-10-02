package sort;

public class MergeSort {
	public static void main(String args[]) {
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	static void sort(int[] nums) {
		if (nums.length == 1) return;
		
		int half = nums.length / 2;
		
		int[] left = new int[half];
		int[] right = new int[nums.length - half];
		
		for (int i = 0; i < half; i ++)
			left[i] = nums[i];
		
		for (int i = half; i < nums.length; i++)
			right[i - half] = nums[i];
			
		sort(left);	
		sort(right);
		
		merge(left, right, nums);				
	}
	
	static void merge(int[] left, int[] right, int[] nums) {
		int i = 0, j = 0, k = 0;
		
		while(i < left.length && j < right.length) {
			if (left[i] <= right[j]) {	// the <= will keep the sorting stable		
				nums[k] = left[i];
				++i;
			} else {
				nums[k] = right[j];
				++j;
			}
			++k;
		}
		
		while (i < left.length) {
			nums[k] = left[i];
			++i;
			++k;
		}
		
		while (j < right.length) {
			nums[k] = right[j];
			++j;
			++k;
		}	
		
	}

}
