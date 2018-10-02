package sort;

public class BubbleSort {
	public static void main(String args[]) {
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	static void sort(int[] nums) {	

		for (int k = 0; k < nums.length - 1; k++) {
			boolean swapped = false;
			for (int i = 0; i < nums.length - k - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					swapped = true;					
				}
			}
			if (!swapped) break;
		}		
	}
}
