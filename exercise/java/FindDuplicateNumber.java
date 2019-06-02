import java.util.*;
//import java.util.Arrays;
//import java.util.HashSet;


public class FindDuplicateNumber {
	public static void main(String[] args) {
		
		FindDuplicateNumber test = new FindDuplicateNumber();
		
		//int[] nums = {2, 2, 3, 1, 4};
		int[] nums = {1, 4, 3, 2, 2};
		System.out.println(test.findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
	    while (low <= high) {
	        int mid = low + (high - low)/2;
	        int cnt = 0;
	        for (int a : nums) {
	            if (a <= mid) ++cnt;
	        }
	        if (cnt <= mid) 
	        	low = mid + 1;
	        else 
	        	high = mid - 1;
	    }
	    return low;
	}
}

