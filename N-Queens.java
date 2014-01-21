/*
he n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/
public class Solution {
    ArrayList<String[]> res = new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        if(n < 0) return res;
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++) a[i] = -1;
        helper(a, 0 n);
        return res;
    }
    public void heler(int[] a, int pos, int n) {
        if(pos == n) doPrint(a);
        else {
            for(int i = 0; i < n; i++) {
                a[pos] = i;
                if(valid(a, pos)) helper(a, pos+1, n);
            }
        }
    }
    public boolean valid(int[] a, int pos) {
        for(int i = 0; i < pos; i++) {
            if(a[pos] == a[i] || Math.abs(a[pos] - a[i]) == pos - i) return false;
        }
        return true;
    }
    public void doPrint(int[] a) {
        int n = a.length;
        String[] sub = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuffer substr = new StringBuffer();
            for(int j = 0; j < n; j++) {
                if(a[i] == j) substr.append("Q");
                else substr.append(".");
            }
            sub[i] = substr.toString();
        }
        res.add(sub);
    }
}