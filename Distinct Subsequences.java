/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
/*DP problem. The transitive function is f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0 
Where f(i, j) is the number of distinct sub-sequence for T[0:j] in S[0:i]. 
We can use O(T) space since the ith-iteration only depends on the i-1th iteration 
and when we calculate from f(i, j) to f(i, 0) for the ith iteration.*/
public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] res = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) res[i][0] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(S.charAt(i-1) == T.charAt(j-1)) {
                    res[i][j] =  res[i-1][j] + res[i-1][j-1];
                }
                else res[i][j] = res[i-1][j];
            }
        }
        return res[m][n];
    }
}
public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = n - 1; j >= 0; j--) {
                if(S.charAt(i) == T.charAt(j)) res[j+1] += res[j];
            }
        }
        return res[n];
    }
}