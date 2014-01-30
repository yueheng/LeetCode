/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(int k = 1; k <= 9; k++) {
                        board[i][j] = (char)(k + '0');
                        if(valid(board, i, j) && helper(board)) return true; 
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][]board, int row, int col) {
        char temp = board[row][col];
        for(int i = 0; i < 9; i++) {
            if(i != row && board[i][col] == temp) return false;
        }
        for(int i = 0; i < 9; i++) {
            if(i != col && board[row][i] == temp) return false;
        }
        int bigrow = 3 * (row / 3);
        int bigcol = 3 * (col / 3);
        for(int i = bigrow; i < bigrow + 3; i++) {
            for(int j = bigcol; j < bigcol + 3; j++) {
                if(i == row && j == col) continue;
                if(board[i][j] == temp) return false;
            }
        }
        return true;
    }
}