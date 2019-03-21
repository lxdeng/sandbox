package unionfind;

public class NumberOfIslands {

	public static void main(String[] args) {
		NumberOfIslands test = new NumberOfIslands();
		char[][] grid ={{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};

		//System.out.println(test.numIslands(grid));
		
		
		int[] parent = new int[8];
		for (int i = 1; i < 8; i++)
			parent[i] = i-1;
		
		int root =find(7, parent);
		
		root =find(4, parent);
		
	}
	
	static int find(int p, int[] parent) {
		 
		int root = p;
		while (parent[root] != root) {
			root = parent[root];
		}
		 
		// compress
		while (p != root) {
			int next = parent[p];
			parent[p] = root;
			p = next;
		}
		
		return root;
	}
	
	public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return count;
            
        int rows = grid.length;
        int cols = grid[0].length;
        
        UF uf = new UF(rows * cols);
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    int p1 = r*cols+c;
                    int p2 = -1;
            
                    uf.add(p1);
                    
                    if (c < cols - 1 && grid[r][c+1] == '1') {
                        p2 = r*cols+c+1;
                        uf.add(p2);
                        uf.union(p1, p2);
                    }
                                
                    if (r < rows - 1 && grid[r+1][c] == '1') {
                        p2 = (r+1)*cols+c;
                        uf.add(p2);
                        uf.union(p1, p2);
                    }
                }
            }

        return uf.components();
    }

}