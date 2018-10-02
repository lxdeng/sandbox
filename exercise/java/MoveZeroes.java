
public class MoveZeroes {
	public static void main(String[] args) {
		Solution sol = new MoveZeroes().new Solution();
		int a[] = {0, 1, 0, 3, 12};
		sol.moveZeroes(a);
		for(int x: a)
			System.out.println(x);
	}
	
	class Solution {
	    public void moveZeroes(int[] nums) {
	    	if (nums == null) return;
	        
	        int nonZeroFound = 0;
	        
	        for (int i=0; i < nums.length; i++) {
	            if (nums[i] != 0) {
	                if (nonZeroFound != i)
	                    nums[nonZeroFound] = nums[i];
	                ++nonZeroFound;
	            }
	        }
	        
	        for (int i = nonZeroFound; i < nums.length; i++)
	            nums[i] = 0;
	    	
	    }
	}
}
