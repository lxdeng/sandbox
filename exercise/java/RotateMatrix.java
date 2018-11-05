
public class RotateMatrix {
	
	
	public static void main(String[] args) {
	
		/*
		int[][] m = 
			{{0,0,0,0,0}, 
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}};
	*/
		
		int[][] m = 
			{{0,0,0,0}, 
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}};
		
		fill(m);
		
		print(m);
	}

	static void fill(int[][] m) {
		
		 int n = m.length;

		 int half = n/2;
		 
		 if (n % 2 == 1)
			 half = half + 1;
		 
	     for (int i = 0; i < half; i++)
	        for (int j = 0; j < n/2; j++) {
	             m[i][j] = 1;  
	        }                  
	}
	
	static void print(int[][]m) {
		
		int n = m.length;
	    for (int i = 0; i < n; i++) {
		       for (int j = 0; j < n; j++) {
		             System.out.print(m[i][j] + "");
		        }  
		       System.out.println();
	    }
	}
	
}
