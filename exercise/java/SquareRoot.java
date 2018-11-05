
import java.util.*;

public class SquareRoot {
	public static void main(String args[]) {
	
		//System.out.println(floorSqrt(Integer.MAX_VALUE));
		
		int a[] = {1,2,2,3,1,4,2};
		
		System.out.println(findShortestSubArray(a));
		
	}
	
	public static int floorSqrt(int x) 
    { 

        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        long temp = x/2; //divide half
        while (temp * temp > x)
            temp = temp/2; //divide half
        while (temp * temp <= x) //in case x=6, temp=1 in previous step, this step corrects it
            temp++;
        return (int)temp-1;
    } 
	
	public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
	
}
