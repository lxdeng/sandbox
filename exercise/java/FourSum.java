import java.util.*;

public class FourSum {
	
	public static void main(String[] args) {
		int[] a = {1,0,-1,0,-2,2};
		
		List<List<Integer>> res = new FourSum().fourSum(a, 0);
	}
	
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        
	        ArrayList<List<Integer>> res = new ArrayList<>();
	        if (nums.length < 4) return res;
	        
	        Arrays.sort(nums);
	        
	        for (int i = 0; i < nums.length - 3; i++) {
	            if (i > 0 && nums[i] == nums[i-1]) continue;
	            
	            for (int j = i + 1; j < nums.length - 2; j++) {
	                if (j > i + 1 && nums[j] == nums[j-1]) continue;
	                
	                int l = j + 1, h = nums.length-1;
	                
	                while (l < h) {
	                    //System.out.println("l=" + l + "h=" + h);
	                    int sum = nums[i] + nums[j] + nums[l] + nums[h];
	                    if (sum == target) {
	                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[l], nums[h]);
	                        res.add(list);

	                        while (l < h && nums[l+1] == nums[l]) l++;
	                        
	                        while (l < h && nums[h-1] == nums[h]) h--;
	                        
	                        l++;
	                        h--;
	                    } else if (sum > target) {
	                        h--;
	                    } else {
	                        l++;
	                    }
	                }// end of while loop
	            }
	        }
	        
	        return res;
	    }
}
