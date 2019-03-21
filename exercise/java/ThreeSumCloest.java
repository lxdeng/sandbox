import java.util.Arrays;

public class ThreeSumCloest {
    int dif = Integer.MAX_VALUE;
    int sum;
    
	public static void main(String[] args) {
		
		ThreeSumCloest test = new ThreeSumCloest();
		
		//int[] nums = {-1,2,1,-4, 6, 5};
		int[] nums = {-1,0,1,1,55};
		System.out.println(test.threeSumClosest(nums, 3));
	
	}
	
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            int target2 = target - nums[i];
            while(j < k) {
                int s = nums[j] + nums[k];
                if (nums[j] + nums[k] == target2)
                    return target;
                else {
                    if (s > target2)
                        --k;
                    else
                        ++j;
                }
            }
          
            int absDif;
            if (j-1 >= 0) {
              absDif = Math.abs(nums[j-1] + nums[j] - target2);
              if (absDif < dif) {
                dif = absDif;
                sum = nums[i] + nums[j-1] + nums[j];
              } 
            }
              
            if (j+1 < nums.length) {
            	absDif = Math.abs(nums[j] + nums[j+1] - target2);
                if (absDif < dif) {
                  dif = absDif;
                  sum = nums[i] + nums[j] + nums[j+1];
                }
            }
              
              
        }
        
        return sum;
	}
}
