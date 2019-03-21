import java.util.*;

public class Combinations {
	public static void main(String args[]) { 
		System.out.println(combine(4,2));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combine(result, nums, new ArrayList<Integer>(), k);
        return result;
    }
    
    static void combine(ArrayList<List<Integer>> result, ArrayList<Integer> nums, ArrayList<Integer>chosen, int k) {
        System.out.println("chosen size=" + chosen.size());
        if (chosen.size() == k) {
            result.add(new ArrayList<Integer>(chosen));
            return;
        }
                       
        for (int i = 0; i < nums.size(); i++) {
            Integer x = nums.remove(i);
            chosen.add(x);
            
            combine(result, nums, chosen, k);

            //restore
            chosen.remove(chosen.size()-1);
            nums.add(i, x);
        }               
        
    }
}
