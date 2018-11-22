

public class MaxAverageSubarrayI {
	public static void main(String[] args) {
		
		int[] nums = {0, 4, 0, 3, 2};
		System.out.println(findMaxAverage(nums, 1));
	}
	
	public static double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int j = 0; j < k; j++)
            max += nums[j];
        
        double prev = max;
        for (int i = 1; i <= nums.length - k; i++) {
            prev = prev + nums[i+k-1]- nums[i-1];
            
            if (prev > max) max = prev;
        }
        
        return max/k;
    }
	
}
