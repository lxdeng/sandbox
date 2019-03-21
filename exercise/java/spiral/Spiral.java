package spiral;

public class Spiral {

	public static void main(String[] args) {
		int[][] r = genSpiral(5);
		for (int[] row : r) {
			for (int x : row)
				System.out.print(x + " ");
			System.out.println();
		}
	}
	
	static int[][] spiral(int n) {
		
		int[][]r = new int[n][n];
		if (n == 0) return r;
		
		int state = 0;
		int seed = 1;
		int i = 0, j = 0;
		
		while (true) {
			if (i >= 0 && i < n && j>=0 && j < n && r[i][j] == 0)
				r[i][j] = seed++;
			else
				return r;
			
			switch(state) {
			case 0:
				if (j+1 < n && r[i][j+1] == 0) {
					++j;
				} else {
					state = 1;
					i++;
				}
				break;
			case 1:
				if (i+1 < n && r[i+1][j] == 0) {
					++i;
				} else {
					state = 2;
					j--;
				}
				break;
			case 2:
				if (j-1 >= 0 && r[i][j-1] == 0) {
					--j;
				} else {
					state = 3;
					--i;
				}
				break;
			case 3:
				if (i-1>= 0 && r[i-1][j] == 0) {
					--i;
				} else {
					state = 0;
					++j;
				}
			}
			
		}
		
	}
	
	public static int[][] genSpiral(int n) {
		   if (n<=0) {
		    throw new IllegalArgumentException("N must be >0");
		   }
		   int[] dc = new int[]{1,0,-1,0};
		   int[] dr = new int[]{0,1,0,-1};
		   int dir = 0, val=0, r=0, c=0,limit=n*n;
		   int[][] matrix = new int[n][n];
		   while (val++ < limit) {
		    matrix[r][c] = val;
		    r += dr[dir];
		    c += dc[dir];
		    if (isInvalid(matrix,r, c)) {
		     r-= dr[dir];
		     c-=dc[dir];
		     dir = (dir+1)%4;
		     r+= dr[dir];
		     c+= dc[dir];
		    }
		   }
		   return matrix;
		  }
	
		  private static boolean isInvalid(int[][] m, int r, int c) {
		   return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
		  } 
	
}
