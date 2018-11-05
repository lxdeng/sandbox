package sort;

public class SelectionSort {
	public static void main(String args[]) {
		int[] a = { 2, 5, 1, 4, 3, 6, 7};
		sort(a);
		for (int x : a)
			System.out.print(x + " ");
	}
	
	// select smallest one, each time
	static void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minPos])
					minPos = j;				
			}	
			
			if (minPos != i) { //swap				
				int temp = nums[i];
				nums[i] = nums[minPos];
				nums[minPos] = temp;				
			}
		}
		
	}
}
