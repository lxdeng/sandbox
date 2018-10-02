package sort;

public class InsertionSort {
	public static void main(String args[]) {
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	static void sort(int[] nums) {	
		for (int i = 1; i < nums.length; i++) {
			//insertIntoSorted(nums, i-1, nums[i]);
			// 0..i-1 already sorted
			int temp = nums[i];
			int j;
			for (j = i - 1; j >= 0; j--) {			
				if (temp < nums[j]) {
					nums[j + 1] = nums[j];		
					//nums[j] = temp;
				} else {
					nums[j + 1] = temp;
					break;
				}
			}
			if (j < 0)
				nums[0] = temp;
		}
	}	
	
}
