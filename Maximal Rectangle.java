/*
Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.
*/
/*
Similar question with largest rectangle in histogram but 
more tough.
we can apply a helper table to convert matrix to another
int[][] helper with calculate the current height for 1 at each 
column until current row.
Such as
char[][] matrix       -> int[][] helper
0,0,0,1,0                   0,0,0,1,0
0,1,1,0,1                   0,1,1,0,1
0,1,1,1,0                   0,2,2,1,0
0,0,1,0,1                   0,0,3, 0,1

then we can apply the method used in largest rectangle in
histogram to get max area which used current row as bottom
then keep updating max area.
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] temp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    if(matrix[i][j] == '0') temp[i][j] = 0;
                    else temp[i][j] = 1;
                }
                else {
                    if(matrix[i][j] == '0') temp[i][j] = 0;
                    else temp[i][j] = temp[i-1][j] + 1;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++) {
            int[] row = new int[n+1];
            for(int j = 0; j < n; j++)  row[j] = temp[i][j];
            row[n] = 0;
            int maxtemp = 0;
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j < n + 1; j++) {
                if(stack.empty() || row[j] > row[stack.peek()]) stack.push(j);
                else {
                    int index = stack.pop();
                    maxtemp = Math.max(maxtemp, row[index] * (stack.empty() ? j : (j - stack.peek() - 1)));
                    j--;
                }
            }
            max = Math.max(max, maxtemp);
        }
        return max;
    }
}