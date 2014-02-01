/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null) return false;
        if(board.length == 0) return false;
        if(word == null) return true;
        if(word.length() == 0) return true;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, i, j) == true) return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int ystart, int xstart) {
        
        if(board[ystart][xstart] != word.charAt(0)) return false;
        if(word.length() == 1)  return true;
        
        board[ystart][xstart] = '#';
        boolean res1 = false, res2 = false, res3 = false, res4 = false;
        if(xstart + 1 < board[0].length) {
            res1 = helper(board, word.substring(1, word.length()), ystart, xstart+1);
            if(res1 == true) {
                board[ystart][xstart] = word.charAt(0); 
                return true;
            }
        }
        if(xstart - 1 >= 0)   {
            res2 = helper(board, word.substring(1, word.length()), ystart, xstart-1);
            if(res2 == true) {
                board[ystart][xstart] = word.charAt(0); 
                return true;
            }
        }           
        if(ystart + 1 < board.length)  {
            res3 = helper(board, word.substring(1, word.length()), ystart+1, xstart);
            if(res3 == true) {
                board[ystart][xstart] = word.charAt(0); 
                return true;
            }
        }  
        if(ystart - 1 >= 0)   {
            res4 = helper(board, word.substring(1, word.length()), ystart-1, xstart);
            if(res4 == true) {
                board[ystart][xstart] = word.charAt(0); 
                return true;
            }
        }           
        board[ystart][xstart] = word.charAt(0); 
        return false;
    }
}