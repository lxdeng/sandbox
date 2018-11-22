import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class FloodFill {
	
	
	
	public static void main(String[] args) {
		int[][] img = createImage();
		printImage(img);
		
		HashSet<int[]> visited = new HashSet<>();
		floodFill(img, 2, 2, 2, 3, visited); // replace color 2 with 3
		
		printImage(img);
	}
	
	public static void floodFill(int[][] img, int r, int c, int color, int newColor, HashSet<int[]> visited) {
		int rows = img.length;
		int cols = img[0].length;
		
		if (r < 0 || r >= rows) return;
		
		if (c < 0 || c >= cols) return;
		
		if (img[r][c] != color) return;
		
		img[r][c] = newColor;
		
		visited.add(new int[] {r, c});
		
		List<int[]> neighbors = getNeighbors(img, r, c);
		
		for (int[] n : neighbors)
			if (!visited.contains(n)) 
				floodFill(img, n[0], n[1], color, newColor, visited);
		
	}
	
	static List<int[]> getNeighbors(int[][] img, int r, int c) {
		ArrayList<int[]> list = new ArrayList<>();
		
		for (int i = r - 1; i <= r+1; i++)
			for (int j = c - 1; j <= c+1; j++)
				if (!(i == r && j == c))
				//if ( i != r || j != c)
					list.add(new int[] {i, j});
		
		//System.out.println("list size=" + list.size());
		return list;
	}
	
	static int[][] createImage() {
		int[][] img = 
			{ {1, 1, 1, 1, 1},
			  {2, 1, 0, 2, 1},
			  {2, 2, 2, 2, 0},
			  {0, 1, 0, 1, 0}};
			  
			  return img;
		
	}
	
	static void printImage(int[][] img) {
		int rows = img.length;
		int cols = img[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.print(img[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
