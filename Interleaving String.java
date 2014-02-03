/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null) return s1 == null && s2 == null;
        if(s1 == null) return s3.equals(s2);
        if(s2 == null) return s3.equals(s1);
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l3 == 0) return l1 == 0 && l2 == 0;
        if(l3 != l1 + l2) return false;
        boolean[][] res = new boolean[l1 + 1][l2 + 2];
        res[0][0] = true;
        for(int i = 0; i < l1; i++) {
            if(s1.charAt(i) == s3.charAt(i)) res[i+1][0] = true;
            else break;
        }
        for(int i = 0; i < l2; i++) {
            if(s2.charAt(i) == s3.charAt(i)) res[0][i+1] = true;
            else break;
        }
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                res[i][j] = (res[i-1][j] == true && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                            (res[i][j-1] == true && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return res[l1][l2];
    }
}