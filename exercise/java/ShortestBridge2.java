import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class ShortestBridge2 {
	static void foo(int y) {
		
	}
	public static void main(String args[]) {
		
		/*
		int a[][] = {{0,1,0}, 
				     {0,0,0},
				     {0,0,1}}; 
				     */
		
		/*
		int a[][] = {{0,1}, 
			        {1,0}};
			        */
		
		int a[][] = 
			{ {1,1,1,1,1},
			  {1,0,0,0,1},
			  {1,0,1,0,1},
			  {1,0,0,0,1},
			  {1,1,1,1,1}
			  };
    
		System.out.println(shortestBridge(a));
	}
	
	public static int shortestBridge(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		
		Queue<Pair> secondIsland = new LinkedList<>();
		
		boolean foundFirstIsland = false;
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++) {
				if (!foundFirstIsland) {
					if (a[r][c] == 1) {	 
						foundFirstIsland = true;
						dfs(a, rows, cols, r , c);
					}
				} else {
					// second island keep the value 1
					if (a[r][c] == 1)
						secondIsland.add(new Pair(r, c));  
				}
				 
			}
		
		
		// BFS grow secondIsland to meet the first island
		int level = 0;
		while (!secondIsland.isEmpty()) {
			int size = secondIsland.size();
			for (int i = 0; i < size; i++) {
				Pair p = secondIsland.remove();
				
				List<Pair> list = getNeighbors(a, rows, cols, p.x, p.y);
				for (Pair n : list) {
					if (a[n.x][n.y] == 3) return level;
					
					if (a[n.x][n.y] == 0) {
						a[n.x][n.y] = 1;
						secondIsland.add(new Pair(n.x, n.y));
					}
				}
			}
			++level;
		}
		
		return -1;
	}
	
	// dfs to get first island, and set to 3
	static void dfs(int a[][], int rows, int cols, int r, int c) {
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(r, c));
		
		while(!stack.empty()) {
			Pair p = stack.pop();
			a[p.x][p.y] |= 2;
			
			List<Pair> nList = getNeighbors(a, rows, cols, p.x, p.y);
			for (Pair n : nList)
				if (a[n.x][n.y] == 1) stack.push(n);
		}

	}
	
	static List<Pair> getNeighbors(int a[][], int rows, int cols, int r, int c) {
		List<Pair> list = new ArrayList<>();
		
		if (r-1 >= 0 ) list.add(new Pair(r-1, c));
		if (r+1 < rows) list.add(new Pair(r+1, c));
		if (c-1 >= 0) list.add(new Pair(r, c-1));
		if (c+1 < cols) list.add(new Pair(r, c+1));
		
		return list;
	}

}

