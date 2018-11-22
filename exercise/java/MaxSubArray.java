
public class MaxSubArray {

	public static void main(String args[]) {
		
		int a[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(maxSubArray(a));
		
	}
	
	
	
	public static int maxSubArray(int[] nums) {

	        if (nums == null || nums.length == 0) return 0;
	    
	        int result = nums[0];
	        
	        // sum(i) stores the max sum of the segment that ends at i position
	        int sum = nums[0];
	        
	        for (int i = 1; i < nums.length; i++) {
	            sum = Math.max(nums[i], nums[i] + sum);
	            result = Math.max(result, sum);
	        }
	        
	        return result;
	}
}
