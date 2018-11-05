
public class RotateArray {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7};
		
		rotate(nums, 3);
		
		for (int n : nums) System.out.print(n + " ");
	}
	
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
	}

}
