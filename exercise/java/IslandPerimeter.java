import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class IslandPerimeter {
	public static void main(String[] args) {
		
		/*int[][] g = {{0,1,0,0},
		            {1,1,1,0},
		            {0,1,0,0},
		            {1,1,0,0}};*/
		
		int[][] g = { {1, 1, 1},
			          {1, 0, 0}};
		System.out.println(islandPerimeter(g));

	}
	
    
    public static int islandPerimeter(int[][] grid) {
        int p = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) 
                if (grid[i][j] == 1)
                    return getPerimeter(grid, i, j, rows, cols);
        
        return 0;
    }
    
    static int processNeighbor(int[][] grid, int i, int j, int rows, int cols, Queue<int[]> queue) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) // out of bounds
            return 1;
        
        if (grid[i][j] == 0)
            return 1;
                    
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            queue.add(new int[]{i, j});
        }
                    
        return 0;
    }
    
    static int getPerimeter(int[][] grid, int i, int j, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {i, j});
        grid[i][j] = -1;
        int p = 0;
        
        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            
            int x = cell[0];
            int y = cell[1];
            
            p += processNeighbor(grid, x-1, y, rows, cols, queue);
            p += processNeighbor(grid, x+1, y, rows, cols, queue);
            p += processNeighbor(grid, x, y-1, rows, cols, queue);
            p += processNeighbor(grid, x, y+1, rows, cols, queue);
        }
        
        return p;
    }
}
