/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 0) return null;
        int[][] res = new int[n][n];
        if(n == 0) return res;
        int i = 0;
        int j = 0;
        int num = 1;
        while(num <= n*n) {
            while(j < n && res[i][j] == 0) {
                res[i][j] = num;
                j++;
                num++;
            }
            j--; i++;
            while(i < n && res[i][j] == 0) {
                res[i][j] = num;
                i++;
                num++;
            }
            i--; j--;
            while(j >= 0 && res[i][j] == 0) {
                res[i][j] = num;
                j--;
                num++;
            }
            j++; i--;
            while(i >= 0 && res[i][j] == 0) {
                res[i][j] = num;
                i--;
                num++;
            }
            i++; j++;
        }
        return res;
    }
}

/*
The key idea is to consider the single step ----- "Which direction to go filling the next number?"
There are only four directions.
Be careful with one thing----- you keep going one direction until meet the end.
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0) return res;
        int i = 1;
        int x = 0;
        int y = 0;
        res[0][0] = i++;
        while(i <= n*n) {
            while(x+1 < n && res[y][x+1] == 0) {  //go right
                x++;
                res[y][x] = i;
                i++;
                
            }
            while(y+1 < n && res[y+1][x] == 0) { //go down
                y++;
                res[y][x] = i;
                i++;
                
            }
            while(x-1 >= 0 && res[y][x-1] == 0) {  //go left
                x--;
                res[y][x] = i;
                i++;
                
            }
            while(y-1 >= 0 && res[y-1][x] == 0) {  //go up
                y--;
                res[y][x] = i;
                i++;
                
            }
        }
        return res;
    }
}