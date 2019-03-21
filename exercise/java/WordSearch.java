import java.util.*;

public class WordSearch {
	public static void main(String args[]) { 
		//char[][] board = {{'b'}, {'a'}, {'b'}};
		char[][] board = {{'A','B','C','E'},
				          {'S','F','E','S'},
				          {'A','D','E','E'}};
				
		String s ="ABCESEEEFS";
				
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, s));
		
	 }
    
	int offset[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (word == null || word.length() == 0) return true;
        
        boolean visited[] = new boolean[rows * cols];
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                
                System.out.println("matched " + word.charAt(0));
                
                if (dfs(board, i, j, word, 1, rows, cols, visited))
                    return true;
                    
                Arrays.fill(visited, false);
            }
                    
        return false;
    }
    
    boolean dfs(char[][] board, int x, int y, String word, int start, int rows, int cols, boolean[] visited) {
        visited[x * cols + y] = true;
        if (start == word.length()) return true;
         
        for (int[] off : offset) {
            int r = x + off[0];
            int c = y + off[1];
            
            if (r < 0 || r >= rows || c < 0 || c >= cols) continue;
            if (visited[r * cols + c]) continue;
            
            if (board[r][c] != word.charAt(start)) continue;
            
            System.out.println("matched " + word.charAt(start) + " start=" + start);
            
            if (dfs(board, r, c, word, start+1, rows, cols, visited))
                return true;
            else
            	visited[r * cols + c] = false;
        }

        return false;
    }
}
