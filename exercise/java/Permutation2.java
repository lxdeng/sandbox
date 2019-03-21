import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Unique permutations

public class Permutation2 {
	 public static void main(String args[]) 
	 { 
		 int nums[] = {1, 1, 2};
		 
		 List<List<Integer>> list = permuteUnique(nums);
		 System.out.println(list);
	 }
	 
	 public static List<List<Integer>> permuteUnique(int[] nums) {
	        
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        if (nums == null || nums.length == 0) return list;
	        
	        Arrays.sort(nums);
	        
	        List<Integer> numsList = new ArrayList<>();
	        for (int n : nums)
	            numsList.add(n);
	        
	        List<Integer> chosen = new ArrayList<>();
	        permute(list, numsList, chosen);
	        return list;
	    }
	    
	    
	  static void permute(List<List<Integer>> list, List<Integer> numsList, List<Integer> chosen) {
	        if (numsList.size() == 0) {
	            list.add(chosen);
	            return;
	        }
	        
	        for (int i = 0; i < numsList.size(); i++) {
	            if (i > 0 && numsList.get(i) == numsList.get(i-1)) continue;
	            
	            Integer x = numsList.remove(i);
	            chosen.add(x);
	            permute(list, numsList, chosen);
	                
	            chosen.remove(chosen.size()-1);
	            numsList.add(i, x);
	        }
	        
	    }
	 
}
