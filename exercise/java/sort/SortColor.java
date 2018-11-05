package sort;

public class SortColor {
	public static void main(String args[]) {
		int[] a = { 2, 0, 2, 1, 1, 0};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	static void sort(int[] nums) {
		 int i = 0, j = 0;
		 
		 for (int k = 0; k < nums.length; k++) {
			 int v = nums[k];
			 nums[k] = 2;
			 
			 if (v < 2) {
				 nums[j] = 1;
				 j += 1;
			 }
				        
			 if (v == 0) {
				 nums[i] = 0;
				 i += 1;
			 }
		 }
	}
	
}
