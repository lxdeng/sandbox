import java.util.*;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		
		int[][] m = {{1, 1, 1},
					{1, 0, 1},
					{1, 1, 1}};
		
		/*
		int[][] m = {{0, 1, 2, 0},
					 {3, 4, 5, 2},
					 {1, 3, 1, 5}};
		/*
		
		int[][] m =  {{-4,-2147483648,6,-7,0},
					{-8,6,-8,-6,0},
					{2147483647,2,-9,-6,-10}};
		*/
		new SetMatrixZeroes().setZeroes(m);
		
	}
	/*
	public static void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        
        int rows = matrix.length;
        if (rows == 0) return;
        
        int cols = matrix[0].length;
        
        boolean firstCol = false; 
            
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                firstCol = true;
            
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // flag columns that need to be set to 0
                    matrix[i][0] = 0; // flag rows that need to be set to 0
                }              
            }           
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        //check first row
        if (matrix[0][0] == 0)
            for (int j = 1; j < cols; j++)
                matrix[0][j] = 0;
        
        
        if (firstCol) {
            for (int j = 0; j < rows; j++)
                matrix[j][0] = 0;
        }
    }*/
	
	/*
	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int r = -1, c = -1; // record first 0 scanned
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    if (r == -1) {
                        r = i;
                        c = j;
                    } else {
                        matrix[i][c] = 0;
                        matrix[r][j] = 0;
                    }
                }    
            }
        
        if (r == -1) return;
        
        for (int i = 0; i < rows; i++) {
            if (i == r) continue;
            
            if (matrix[i][c] == 0)
                for (int j = 0; j < cols; j++) 
                    matrix[i][j] = 0;
                
        }
        
        for (int i = 0; i < cols; i++) {
            if (matrix[r][i] == 0)
                for (int j = 0; j < rows; j++) 
                    matrix[j][i] = 0;
        }
        
    }*/
	
	public void setZeroes(int[][] matrix) {
        int row = -1, col = -1;
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][i] == 0) {
                    if (row == -1) {
                        row = i;
                        col = j;
                    } else {
                        matrix[row][j] = 0;
                        matrix[i][col] = 0;
                    }
                }
            }
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == row || j == col) continue;
             
                if (matrix[row][j] == 0 || matrix[i][col] == 0)
                    matrix[i][j] = 0;
            }
        
        //print(matrix);
        
        for (int i = 0; i < matrix.length; i++)
            matrix[i][col] = 0;
        
        for (int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = 0;
    }
}
