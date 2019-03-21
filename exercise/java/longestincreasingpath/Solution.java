package longestincreasingpath;

public class Solution {
    int dp[][]; // longest increasing path from this cell
    int offset[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) {
    	int m[][] = {{9,9,4}, {6,6,8}, {2,1,1}};
    	
    	Solution sol = new Solution();
    	
    	System.out.println(sol.longestIncreasingPath(m));
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        dp = new int[rows][cols];
        
        int max = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.println(dp[i][j] + " ");
            System.out.println();
        }
        return max;
    }
    
    int dfs(int[][] matrix, int i, int j) {        
        if (dp[i][j] > 0) return dp[i][j];
        
        int len = 1;

        for (int[] o : offset) {
            int x = i + o[0];
            int y = j + o[1];
            
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;
            
            len += dfs(matrix, x, y);
        }

        dp[i][j] = len;
        return len;
    }
}