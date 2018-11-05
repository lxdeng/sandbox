
public class RemoveDuplicated {
	public static void main(String[] args) {
		int nums[]= {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(removeDuplicates(nums));
		
	}
	
	public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int pos = 1;
        int start = 0;
        int end = 1;
        
        while (true) {
            while (end < n && nums[end] == nums[start])
                ++end;
            
            if (end >= n)
                return pos;
            
            start = end;
            end += 1;
            
            nums[pos++] = nums[start];            
        }
      
    }
}
