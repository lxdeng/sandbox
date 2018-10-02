import java.util.Arrays;
import java.util.List;

public class SingleNumber {

  public static void main(String[] args) {
		Solution sol = new SingleNumber().new Solution();
		
		int x[] = {2, 2, 1};
		System.out.println(sol.singleNumber(x));
		
		Integer y[] = {2, 2, 1};
		
		List<Integer> list = Arrays.asList(y);
		
		System.out.println(sol.singleNumber(list));
		
  }

  class Solution {
	    public int singleNumber(int[] nums) {
	        for (int i = 0; i < nums.length; i++) {
	            boolean paired = false;
	            for (int j = 0; j < nums.length; j++) {
	                if (i != j && nums[i] == nums[j]) {
	                    paired = true;
	                    break;
	                }                  
	            }
	            
	            if (!paired)
	                return nums[i];
	        }
	        
	        // should not reach here
	        return 0;
	    }
	    
	 // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public int singleNumber(final List<Integer> A) {
	         for (int i = 0; i < A.size(); i++) {
	            boolean paired = false;
	            for (int j = 0; j < A.size(); j++) {
	                if (i != j && A.get(i) == A.get(j)) {
	                    paired = true;
	                    break;
	                }                  
	            }
	            
	            if (!paired)
	                return A.get(i);
	        }
	        
	        // should not reach here
	        return 0;
	   }
	}
}