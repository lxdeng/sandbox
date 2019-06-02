
public class SubArrayProductLessthanK {
	
	public static void main(String[] args) {
		SubArrayProductLessthanK test = new SubArrayProductLessthanK();
		
		int nums[] = {10,5,2,6};
		int k = 0;
		
		System.out.println(test.numSubarrayProductLessThanK(nums, k));
	}
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		 int cnt = 0;
	        
	        int start = 0, end = 0;
	        
	        int p = nums[end];
	        while (end < nums.length) {    
	            if (p < k) { // increase the count of sub-arrays ends at "end"
	                ++end;
	                cnt += end-start;
	                if (end < nums.length)
	                    p *= nums[end];
	            } else { // start ...(end-1)                
	                while (p >= k && start <= end) {
	                    p /= nums[start++];
	                }
	                if (start > end)
	                    end = start;
	            }
	        }

	        return cnt;
    }
}
