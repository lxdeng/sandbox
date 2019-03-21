
public class SortColors {
	public static void main(String args[]) {
		int a[] = {2, 0, 2, 1, 1, 0};
		new SortColors().sortColors(a);
	}
	
	/*
    quicksort 3-way partition
+------+---------+-------------+-------+
|  <p  |  =p     |  unseen .  |   > p  |
+------+---------+------------+-------+
    ↑          ↑           ↑
    lt         i            gt 
lt: 1st elem == pivot
i:  1st unseen elem
gt: last unseen elem
*/
	/*
	 public void sortColors(int[] nums) {
	        // pos1 start of ones
	        // pos2 start of twos
	        int pos1 = 0, pos2 = nums.length - 1;
	        
	        int i = 0;
	        while (i <= pos2) {
	            if (nums[i] == 0) {
	                nums[pos1] = 0;
	                nums[i] = 1;
	                pos1++;
	                i++;
	            } else if (nums[i] == 1) {
	                i++;
	            } else { //2
	                nums[i] = nums[pos2];
	                nums[pos2--] = 2;
	            }
	        }// end of while
	    }
	*/
	
	public void sortColors(int[] nums) {
	    int start = 0;
	    int end = nums.length - 1;
	    int i = 0;
	    while (i <= end) {
	        if (nums[i] == 0) {
	            nums[i]=1;
	            nums[start]=0;
	            start++;
	            i++;
	        } else if (nums[i] == 2) {
	            nums[i]=nums[end];
	            nums[end]=2;
	            end--;
	        } else {
	            i++;
	        }
	    }
	  }
	
// 3-way partition used in quick sort
  public void sortColors2(int[] nums) {
    int lt = 0, i = 0, gt = nums.length - 1;
    while (i <= gt) {
        if (nums[i] == 0) {
            swap(nums, lt++, i++);
        } else if (nums[i] == 2) {
            swap(nums, i, gt--);
        } else { // nums[i] == 1
            i++;
        }
    }
  }

  void swap(int[] nums, int i, int j) {
    if (i == j) return;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

