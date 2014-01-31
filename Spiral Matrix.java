/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return res;
        int xbegin = 0, xend = matrix[0].length - 1;
        int ybegin = 0, yend = matrix.length - 1;
        while(true) {
            for(int i = xbegin; i <= xend; ++i) res.add(matrix[ybegin][i]);
            if(++ybegin > yend) break;
            for(int i = ybegin; i <= yend; ++i) res.add(matrix[i][xend]);
            if(--xend < xbegin) break;
            for(int i = xend; i >= xbegin; --i) res.add(matrix[yend][i]);
            if(--yend < ybegin) break;
            for(int i = yend; i >= ybegin; --i) res.add(matrix[i][xbegin]);
            if(++xbegin > xend) break;
        }
        return res;
    }
}