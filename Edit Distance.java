/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null) return word2.length();
        if(word2 == null) return word1.length();
        int m = word1.length(), n =word2.length();
        int[][] res = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++) res[i][0] = i;
        for(int i = 1; i < n+1; i++) res[0][i] = i;
        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))  res[i][j] = res[i-1][j-1];
                else {
                    int min = Math.min(res[i - 1][j], res[i][j - 1]);
                    res[i][j] = 1 + Math.min(min, res[i-1][j-1]);
                }
            }
        }
        return res[m][n];
    }
}