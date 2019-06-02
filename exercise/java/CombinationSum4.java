import java.util.Arrays;

public class CombinationSum4 {
	public static void main(String args[]) { 
		
		CombinationSum4 cs4 = new CombinationSum4();
		int[] nums = {1, 2, 3};
		int target = 35;
		int count = cs4.combinationSum4(nums, target);
		System.out.println(count);
	}
	

	int count;
    public int combinationSum4(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        search(nums, target);
        return count;
    }
    
    void search(int[] nums, int remain) {
        if (remain == 0) {
            ++count;
            return;
        }
        
        for (int n : nums) {
            int rem = remain - n;
            if (rem < 0) return;
            
            search(nums, rem);
        }
    }
}
