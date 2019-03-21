package matrix01;

import java.util.*;

class Solution {
    int marker = 2;
    int offset[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    
    public static void main(String args[]) {
    	
    	int [][] m = {
    			{0,0,0},
    			{0,1,0},
    			{0,1,0}
    	};
    	
    	new Solution().updateMatrix(m);
    	
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int r[][] = new int[rows][cols];
        //for (int[] row : r)
        //    Arrays.fill(row, -1);
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 0)
                    r[i][j] = 0;
                else {
                    r[i][j] = stepsToZero(matrix, i, j, rows, cols);    
                    ++marker;
                }
          
        return r;
    }
    
    int stepsToZero(int[][] matrix, int i, int j, int rows, int cols) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * cols + j);        
        int step = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int k = 0; k < size; k++) {
                int cell = queue.remove();
                int x = cell / cols;
                int y = cell % cols;
                matrix[x][y] = marker;
                
                for (int[] o : offset) {
                    int xx = x + o[0];
                    int yy = y + o[1];
                    if (xx < 0 || xx > rows - 1 || yy < 0 || yy > cols - 1) break;
                    
                    if (matrix[xx][yy] == 0) return step;
                    if (matrix[xx][yy] != marker)
                        queue.add(xx * cols + yy);
                } 
            }
            ++ step;
        } // end of while loop
        return step;
    }
    
}