package maximalrectangle;

class Solution {
	
	public static void main(String args[]) {
		char[][] m = {
				{'1','1','1','1','1','1','1','1'},
				{'1','1','1','1','1','1','1','0'},
				{'1','1','1','1','1','1','1','0'},
		        {'1','1','1','1','1','0','0','0'},
				{'0','1','1','1','1','0','0','0'}};
				
		System.out.println(new Solution().maximalRectangle(m));
		
	}
	
    public int maximalRectangle(char[][] matrix) {
        //brutal force
        
        int rows = matrix.length;
        if (rows == 0) return 0;
        
        int cols = matrix[0].length;
        
        int maxArea = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int area = areaOne(i, j, matrix, rows, cols);
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        return maxArea;
    }
    
    private int areaOne(int sX, int sY, char[][]matrix, int rows, int cols) {
        int area = 0;
        
        for (int i = sX; i < rows; i++)
            for (int j = sY; j < cols; j++) {
                int a = area(sX, sY, i, j, matrix);  
                if (a > area)
                    area = a;
            }
        
        return area;
    }
    
    int area(int sX, int sY, int eX, int eY, char[][]matrix) {
        //System.out.println(sX + ' ' + sY + ' ' + eX + ' ' + eY);
        if (sX == 0 && sY ==0 && eX == 2 && eY == 6)
            System.out.println("found it: ");
             
        for (int i = sX; i <= eX; i++)
            for (int j = sY; j <= eY; j++) {
                if (matrix[i][j] == '0')
                    return 0;
            }
        
        if (sX == 0 && sY ==0 && eX == 2 && eY == 6) {
            System.out.println("found it: " + (eX-sX+1) * (eY-eX+1));
        }
        
        return (eX-sX+1) * (eY-eX+1);
    }
        
}