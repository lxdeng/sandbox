package rawtype;

public class Test {
	public static void main(String[] args) {
		/*
		Box<String> b1 = new Box<>();
		b1.set("Hello");
		System.out.println(b1.get());
		
		b1.testGenericMethod1('x');
		
		Box b2 = new Box();
		b2.set(1);
		System.out.println(b2.get());
		
		b2 = b1;
		b2.set(1.1);
		System.out.println(b2.get());
		*/
		//System.out.println(b1.get());
		
		int[] a = {1,2,3,4,5,6};
		rotate(a, 3);
	}
	
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
