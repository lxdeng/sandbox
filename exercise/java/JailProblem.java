import java.util.*;

public class JailProblem {
	
	HashMap<Integer, int[]> map;
	HashSet<Integer> set;
	
	public static void main(String args[]) {
		int[] state = {0, 1, 1, 0, 0, 0, 0, 1};
		
		JailProblem test = new JailProblem();
		
		int[] res = test.nextNState(state, 10);
		System.out.print("res= ");
		test.print(res);	
		
		res = test.nextNState2(state, 10);
		System.out.print("res2= ");
		test.print(res);	
		
	}
	
	int toInt(int[] state) {
		int res = 0;
		for (int i = 0; i < 8; i++) {
			res = res * 2 + state[i];
		}
		return res;
	}
	
	void print(int[] state) {
		for (int x : state) 
			System.out.print(x + " ");
		System.out.println();
	}
	
	int[] nextNState2(int[] state, int n) {
		
		map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		
		int max = 0; 
		
		int[] res = state;
		for (int i = 0; i < 256; i++) {
			int x = toInt(res);
			
			if (set.contains(x)) {
				max = i + 1;
				break;
			} else {
				set.add(x);
				map.put(i, res);
			}
			
			res = next(res);
			if (n == i + 1)
				return res;
		}
		
		return map.get(n % max);
	}
	
	// state after n days, if left and right are active or inactive, change it to active, otherwise inactive
	int[] nextNState(int[] state, int n) {
		for (int i = 0; i < n; i++) {
			state = next(state);
		}
		
		return state;
	}
	
	int[] next(int[] state) {
		int[] state2 = new int[state.length];
		//System.arraycopy(state, 0, state2, 0, state.length);
		
		for (int i = 0; i < state.length; i++) {
			int left = (i == 0 ? state.length-1 : i - 1);
			int right = (i == state.length-1 ? 0 : i + 1);
			
			if (state[left] == state[right])
				state2[i] = 1;
			else
				state2[i] = 0;
		}
		
		print(state2);
		return state2;
	}
}
