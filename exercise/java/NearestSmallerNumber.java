
import java.util.*;

public class NearestSmallerNumber {
	public static void main(String args[]) {
		NearestSmallerNumber test = new NearestSmallerNumber();
		//int[] nums = {1, 6, 4, 10, 2, 5};
		int[] nums = {1, 3, 0, 2, 5};
		int res[] = test.nearestSmaller(nums);
		
		for (int x : res)
			System.out.print(x + " ");
	}
	
	int[] nearestSmaller(int[] nums) {
		int[] res = new int[nums.length];
		
		Deque<Integer> stack = new LinkedList<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && stack.peek() >= nums[i]) {
				stack.pop();
			}
			
			if (stack.isEmpty())
				res[i] = -1;
			else
				res[i] = stack.peek();
			
			stack.push(nums[i]);
		}
		
		return res;
	}
}
