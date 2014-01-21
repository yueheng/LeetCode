/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] row = new boolean[9][9];
       boolean[][] col = new boolean[9][9];
       boolean[][] block = new boolean[9][9];
       for(int i = 0; i < 9; i++) {
           for(int j = 0; j < 9; j++) {
               if(board[i][j] == '.') continue;
               int c = board[i][j] - '1';
               if(row[i][c] == true || col[j][c] == true || block[3*(i/3) + j/3][c] == true) return false;
               else row[i][c] = col[j][c] = block[3*(i/3) + j/3][c] = true;
           }
       }
       return true;
    }
}