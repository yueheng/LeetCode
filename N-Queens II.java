/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/
public class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        if(n < 0) return res;
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++) a[i] = -1;
        helper(a, 0, n);
        return res;
    }
    
   public void helper(int[] a, int pos, int n) {
        if(pos == n) res++;
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
}