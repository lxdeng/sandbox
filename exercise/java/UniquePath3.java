
public class UniquePath3 {
	public static void main(String args[]) {
		int[][] a = {{1,0}, {2,0}};
		
		int r = new UniquePath3().new Solution().uniquePathsIII(a);
		System.out.println(r);
	}
	
	class Solution {
	    int paths = 0;
	    int rows;
	    int cols;
	    int[][] offset = {{-1,0}, {1,0}, {0,-1},{0,1}};
	    
	    public int uniquePathsIII(int[][] grid) {
	        rows = grid.length;
	        cols = grid[0].length;
	        
	        boolean visited[][] = new boolean[rows][cols];
	        
	        for (int i = 0; i < rows; i++)
	            for (int j = 0; j < cols; j++) {
	                if (grid[i][j] == 1) {
	                    visited[i][j] = true;
	                    dfs(grid, i, j, 1, visited);
	                    return paths;
	                }
	            }
	        
	        return paths;
	    }
	    
	    void dfs(int[][] grid, int r, int c, int count, boolean[][] visited) {
	        //System.out.println("count=" + count);
	        
	        if (count == rows * cols) {
	            if (grid[r][c] == 2)
	                ++paths;
	            return;
	        }
	        
	        for (int[] ofs : offset) {
	            int rr = r + ofs[0];
	            int cc = c + ofs[1];
	            
	            if (rr < 0 || rr >= rows || cc < 0 || cc >= cols || grid[rr][cc] == -1)
	                continue;
	            
	            if (grid[rr][cc] == 2 && count + 1 != rows *cols)
	                continue;
	            
	            visited[rr][cc] = true;
	            dfs(grid, rr, cc, count + 1, visited);
	            visited[rr][cc] = false; 
	        }
	    }
	}
}
