package validsudoku;

public class Sudoku {
	
	public static void main(String args[]) {
		Solution sol = new Solution();
		char[][] board = createSudoku();
		System.out.println(sol.isValidSudoku(board));
	}
	
	private static char[][] createSudoku() {
		char[][] s = new char[9][9];
		
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				s[i][j] = '.';
		
		s[0][0] = '5';
		s[0][1] = '3';
		s[0][4] = '7';
		
		s[1][0] = '6';
		s[1][3] = '1';
		s[1][4] = '9';
		s[1][3] = '5';
		
		
		
		return s;
	}
	
}
