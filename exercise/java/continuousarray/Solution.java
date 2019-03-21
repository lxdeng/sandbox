package continuousarray;

public class Solution {
	public static void main(String[] args) {
		int[] nums = {0,1,1,0,1,1,1,0};
		
		System.out.println(new Solution().findMaxLength(nums));
	}

    public int findMaxLength(int[] nums) {
        int[] zeroMap = new int[nums.length];
        int[] oneMap = new int[nums.length];
        
        int zeroes = 0, ones = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroes++;
            else
                ones++;
            
            zeroMap[i] = zeroes;
            oneMap[i] = ones;
        }
        
        int j = 0, k = nums.length-1;
        
        while (j <= k) {
            if (j == 0) {
                zeroes = zeroMap[k];
                ones = oneMap[k];
            } else {
                zeroes = zeroMap[k] - zeroMap[j-1];
                ones = oneMap[k] - oneMap[j-1];
            }
            if (ones == zeroes) return k-j+1;
                
            if (ones > zeroes) {
               if (nums[j] == 1) {
                   ++j;
                   continue;
                }
                
                if (nums[k] == 1) {
                    --k;
                    continue;
                }
                
                j++;
                
            } else { // ones < zeroes
                if (nums[j] == 0) {
                   ++j;
                   continue;
                }
                
                if (nums[k] == 0) {
                    --k;
                    continue;
                }
                
                j++;
            }
            
        } // end of while loop
    
        return 0;
    }
}