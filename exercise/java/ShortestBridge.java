import java.util.Queue;

import java.util.LinkedList;

public class ShortestBridge {
	public static void main(String args[]) {
		
		int a[][] = {{0,1,0}, 
				     {0,0,0},
				     {0,0,1}}; 
		
		int m = 3, n = 3;
		
		outerLoop:
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					bfs(a, m, n, i, j);
					break outerLoop;
				}
			}
		}
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void bfs(int a[][], int m, int n, int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		
		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			a[p.x][p.y] |= 2;
			
			if (p.x - 1 >= 0 && a[p.x-1][p.y] == 1) queue.add(new Pair(p.x-1, p.y));
			if (p.x + 1 < m && a[p.x+1][p.y] == 1) queue.add(new Pair(p.x+1, p.y));
			if (p.y - 1 >= 0 && a[p.x][p.y-1] == 1) queue.add(new Pair(p.x, p.y-1));
			if (p.y + 1 < n && a[p.x][p.y+1] == 1) queue.add(new Pair(p.x, p.y+1));
		}
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
