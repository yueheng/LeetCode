/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
public class Solution {
    public int minCut(String s) {
        if(s == null) return 0;
        int n = s.length();
        int[] min = new int[n + 1];
        boolean[][] valid = new boolean[n][n];
        for(int i = 0; i <= n; i++) min[i] = i; //the worst case is cutting by each char  
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 0; j--) {
                if(s.charAt(j) == s.charAt(i) && (i - j < 2 || valid[i-1][j+1] == true)) {
                    valid[i][j] = true;
                    min[i+1] = Math.min(min[i+1], min[j] + 1);
                }
            }
        }
        return min[n] - 1;
    }
}