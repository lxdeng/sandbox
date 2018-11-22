package cube;

import java.util.*;

// a^3 + b^3 = c^3 + d^3
public class Test {
	public static void main(String args[]) {

		int test = Integer.MAX_VALUE;
		//test = test << 31;
		
		test = test << 1;
		int n = 300;
		long start, end;
		int count;

		start = System.currentTimeMillis();
		count = brute(n);
		end = System.currentTimeMillis();
		System.out.printf("brute count = %d, millis=%d\n", count, end-start);
		
		start = System.currentTimeMillis();
		count = brute2(n);
		end = System.currentTimeMillis();
		System.out.printf("brute2 count = %d, millis=%d\n", count, end-start);
		
		start = System.currentTimeMillis();
		count = usePow(n);
		end = System.currentTimeMillis();
		System.out.printf("usePow count = %d, millis=%d\n", count, end-start);
		
		start = System.currentTimeMillis();
		count = useMap(n);
		end = System.currentTimeMillis();
		System.out.printf("useMap count = %d, millis=%d\n", count, end-start);

		start = System.currentTimeMillis();
		count = useMap2(n);
		end = System.currentTimeMillis();
		System.out.printf("useMap2 count = %d, millis=%d\n", count, end-start);
	}
	
	private static int brute(int n) {
		int count = 0;
		for (int a = 1; a < n; a++)
			for (int b = 1; b < n; b++)
				for (int c = 1; c < n; c++)
					for (int d = 1; d < n; d++)
						if (a*a*a + b*b*b == c*c*c + d*d*d)
							count++;
							//System.out.printf("%d %d %d %d\n", a, b, c, d);
		
		return count;
	}
	
	private static int brute2(int n) {
		int count = 0;
		for (int a = 1; a < n; a++)
			for (int b = 1; b < n; b++)
				for (int c = 1; c < n; c++)
					for (int d = 1; d < n; d++)
						if (a*a*a + b*b*b == c*c*c + d*d*d) {
							count++;
							break;
						}
		
		return count;
	}
	
	private static int usePow(int n) {
		int count = 0;
		for (int a = 1; a < n; a++)
			for (int b = 1; b < n; b++)
				for (int c = 1; c < n; c++) {
					double y = (double)1/(double)3;
					double x = (int)Math.pow(a*a*a + b*b*b - c*c*c, y);
					int d = (int)x;
					int delta = a*a*a + b*b*b - c*c*c;
					if (d != 0 && delta == d*d*d)
					    count++;
					else if ((d+1) != 0 && delta == (d+1)*(d+1)*(d+1))
						count++;
					else if ((d-1) != 0 && delta == (d-1)*(d-1)*(d-1))
						count++;
				}
					
		return count;
	}
	
	private static int useMap(int n) {
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
		
		int count = 0;
		for (int c = 1; c < n; c++) 
			for (int d = 1; d < n; d++) {
				int result = c*c*c + d*d*d;
				if (map.containsKey(result)) {
					ArrayList<Pair> list = map.get(result);
					list.add(new Pair(c,d));
					map.put(result, list);
				} else {
					ArrayList<Pair> list = new ArrayList<>();
					list.add(new Pair(c,d));
					map.put(result, list);
				}
			}
		
		for (int a = 1; a < n; a++)
			for (int b = 1; b < n; b++) {
				int result = a*a*a + b*b*b;
				if (map.containsKey(result)) {
					ArrayList<Pair> list = map.get(result);
					count += list.size();
				}
			}

		return count;
	}
	
	private static int useMap2(int n) {
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
		
		int count = 0;
		for (int c = 1; c < n; c++) 
			for (int d = 1; d < n; d++) {
				int result = c*c*c + d*d*d;
				if (map.containsKey(result)) {
					ArrayList<Pair> list = map.get(result);
					list.add(new Pair(c,d));
					map.put(result, list);
				} else {
					ArrayList<Pair> list = new ArrayList<>();
					list.add(new Pair(c,d));
					map.put(result, list);
				}
			}

		for (Integer result: map.keySet()) {
			ArrayList<Pair> list = map.get(result);
			
			for (Pair p: list) {
				for (Pair p2: list) {
					++count;
				}
			}		
		}
		
		return count;
	}
					
}

class Pair {
	int c;
	int d;
	
	Pair(int c, int d) {
		this.c = c;
		this.d = d;
	}
}
