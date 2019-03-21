import java.util.*;

public class WordSearch2 {
	public static void main(String args[]) { 
		//char[][] board = {{'b'}, {'a'}, {'b'}};
		char[][] board = {{'a','b'},
				          {'c','d'}};
				
		String[]  words = {"ab", "cb", "ad", "ac", "bd"};
				
		WordSearch2 ws = new WordSearch2();
		List<String> res = ws.findWords(board, words);
		
		for (String r : res)
			System.out.println(r);
		
	 }
    
	int offset[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        
        boolean visited[] = new boolean[rows * cols];
        List<String> list = new ArrayList<>();
        
        for (String w : words) {
            if (exist(w, board, visited)) {
                list.add(w);
                Arrays.fill(visited, false);
            } 
        }
        
        return list;
    }
    
    boolean exist(String w, char[][] board, boolean[] visited) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                 if (exist(w.toCharArray(), 0, board, i, j, visited)) 
                     return true;
            }
        
        return false;
    }
    
    boolean exist(char[] w, int start, char[][] board, int i, int j, boolean[] visited) {        
        int rows = board.length;
        int cols = board[0].length;
        
        if (visited[i * cols + j] || board[i][j] != w[start])
            return false;
        
        visited[i * cols + j] = true;
        if (start + 1 == w.length) return true;
        
        for (int[] of : offset) {
            int x = i + of[0];
            int y = j + of[1];
            if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
            
            if (exist(w, start+1, board, x, y, visited)) {
                visited[i * cols + j] = false;
                return true;
            }    
        }
        
        visited[i * cols + j] = false;
        return false;
    }
}