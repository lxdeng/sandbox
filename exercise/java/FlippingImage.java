
public class FlippingImage {


	public static void main(String[] args) {
		int[][] x = 
			{{1,1,0},
			{1,0,1},
			{0,0,0}};
		
		flipAndInvertImage(x);
		printImage(x);
	
	}
	
    public static int[][] flipAndInvertImage(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0)
            return a;
        
        int rows = a.length;
        int cols = a[0].length;
        
        for (int c = 0; c < cols/2; c++) {
            for (int r = 0; r < rows; r++) {
                int tmp = a[r][c];
                a[r][c] = a[r][cols-1-c] == 0 ? 1 : 0;
                a[r][cols-1-c] = tmp == 0 ? 1 : 0;
            }
        }
        
        if (cols % 2 != 0) {
            int c = cols/2;
            for (int r = 0; r < rows; r++)
                a[r][c] = a[r][c] == 0 ? 1 : 0;
        }
        
        return a;
    }
    
    public static void printImage(int[][] a) {
    	for (int r = 0; r < a.length; r++) {
    		for (int c = 0; c < a[0].length; c++)
    			System.out.print(a[r][c] + " ");
        	System.out.println();		
    	}		

    }
}
