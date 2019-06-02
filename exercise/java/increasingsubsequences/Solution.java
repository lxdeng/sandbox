package increasingsubsequences;

import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		int[] a = {4, 2, 5};
		
		List<List<Integer>> r = new Solution().findSubsequences(a);
	}
	
	public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        search(res, nums, 0, new ArrayList<>());
        return res;
    }
    
    void search(ArrayList<List<Integer>> res, int[] nums, int start, ArrayList<Integer> chosen) {
        HashSet<Integer> used = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) continue; // avoid dup
            
            if (chosen.size() == 0 || nums[i] >= chosen.get(chosen.size()-1)) {
                used.add(nums[i]);
                chosen.add(nums[i]);
                if (chosen.size() > 1)
                    res.add(new ArrayList<>(chosen));
  
                search(res, nums, i + 1, chosen);
                chosen.remove(chosen.size()-1);
            }    
        } // end of for
    }
}