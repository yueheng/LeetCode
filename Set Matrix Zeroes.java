/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        boolean col = false, row = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                col = true;
                break;
            }
        }
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                row = true; 
                break;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < n; j++) matrix[i][j] = 0;
            }
        }
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < m; j++) matrix[j][i] = 0;
            }
        }
        if(matrix[0][0] == 0) {
            col = true;
            row = true;
        }
        if(col == true) {
            for(int i = 0; i < m; i++) matrix[i][0] = 0;
           
        }
        if(row == true) {
            for(int i = 0; i < n; i++) matrix[0][i] = 0;
        }
    }
}