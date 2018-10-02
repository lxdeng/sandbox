import java.util.ArrayList;
import java.util.List;

public class Permutation {
	 public static void main(String args[]) 
	 { 
		 int nums[] = {1, 2, 3};
		 
		 List<List<Integer>> list = permute(nums);
		 System.out.println(list);
	 }
	 
	 public static List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>();	
		 
		 List<Integer> numsList = new ArrayList<Integer>();
		 for (int n : nums) numsList.add(n);
		 
		 List<Integer> chosen = new ArrayList<Integer>();
		
		 permute(list, numsList, chosen);
		 return list;
	 }
	 
	 public static void permute(List<List<Integer>> list, List<Integer> nums, List<Integer> chosen) {
		 if (nums.size() == 0) {
			 List<Integer> onePermute = new ArrayList<Integer>(chosen);
			 list.add(onePermute);
			 return;
		 }
		 
		 for (int i = 0; i < nums.size(); i++) {
			 Integer n = nums.remove(i);
			 chosen.add(n);
			 permute(list, nums, chosen);		
			 
			 nums.add(i, n);
			 chosen.remove(chosen.size() - 1);
		 }		 		 
		 
	 }
	 
}
