
public class Base2Conversion {
	public static void main(String args[]) {
		System.out.println(base2(0));
		System.out.println(base2(1));
		System.out.println(base2(16));
		System.out.println(base2(-7));
		
		System.out.println();
		
		System.out.println(base2Loop(0));
		System.out.println(base2Loop(1));
		System.out.println(base2Loop(16));
		System.out.println(base2Loop(-7));
		
		System.out.println();
		
		System.out.println(base2BinString(0));
		System.out.println(base2BinString(1));
		System.out.println(base2BinString(16));
		System.out.println(base2BinString(-7));
		
		System.out.println();
		
		System.out.println(base2BitShift(0));
		System.out.println(base2BitShift(1));
		System.out.println(base2BitShift(16));
		System.out.println(base2BitShift(-7));

	}
	
	static String base2(int n) {
		if (n < 0)
			return "-" + base2(-n);
		
		if (n < 2)
			return Integer.toString(n);
		
		return base2(n/2) + Integer.toString(n % 2);
	}
	
	static String base2Loop(int n) {
		if (n == 0)
			return "0";
		
		boolean neg = false;
		if (n < 0) {
			neg = true;
			n = -n;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append(n % 2);
			n /= 2;
		}
		
		if (neg)
			sb.append('-');
		
		return sb.reverse().toString();
	}
	
	static String base2BinString(int n) {
		if (n < 0)
			return "-" + base2BinString(-n);
		
		return Integer.toBinaryString(n);
	}
	
	static String base2BitShift(int n) {
		if (n < 0)
			return "-" + base2BitShift(-n);
		
		if (n == 0)
			return "0";
		
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append(n & 1);
			n >>= 1;
		}
		
		return sb.reverse().toString();
	}
	
}
