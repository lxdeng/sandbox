package validsudoku;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character> set = new HashSet<>();
        for (int r = 0; r < n; r++) {
            set.clear();
            for (int c = 0; c < n; c++) {
                if (board[r][c] != '.' && set.contains(board[r][c]))
                    return false;
                else
                    set.add(board[r][c]);
            }
        }
        
        for (int c = 0; c < n; c++) {
            set.clear();
            for (int r = 0; r < n; r++) {
                if (board[r][c] != '.' && set.contains(board[r][c]))
                    return false;
                else
                    set.add(board[r][c]);
            }
        }
        
        for (int r = 0; r < 9; r = r + 3)
            for (int c = 0; c < 9; c = c + 3)
                if (!isValidSubBox(board, r, c, 3, set))
                    return false;
            
        return true;
    }
    
    private boolean isValidSubBox(char[][] board, int row, int col, int n, HashSet<Character> set) {
        set.clear();
        for (int r = row; r < row + n; r++)
            for (int c = col; c < col + n; c++)
                if (board[r][c] != '.' && set.contains(board[r][c]))
                    return false;
                else
                    set.add(board[r][c]);
        
        return true;
    }
}