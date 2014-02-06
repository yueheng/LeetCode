/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
//http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
public class Solution {
    public String minWindow(String S, String T) {
        int slen = S.length(), tlen = T.length();
        int minWindowLen = Integer.MAX_VALUE;
        int[] need = new int[256];
        for(int i = 0; i < tlen; i++) need[T.charAt(i)]++;
        int[] has = new int[256];
        int count = 0;
        int minWindowBegin = 0;
        int minWindowEnd = slen - 1;
        
        for (int begin = 0, end = 0; end < slen; end++) {
            char c = S.charAt(end);
            if (need[c] == 0) continue;// skip characters not in T
            has[c]++;
            if (has[c] <= need[c])  count++;
            if (count == tlen) {  // if window constraint is satisfied
                                // advance begin index as far right as possible,
                                // stop when advancing breaks window constraint.
                while (need[S.charAt(begin)] == 0 || has[S.charAt(begin)] > need[S.charAt(begin)]) {
                    if (has[S.charAt(begin)] > need[S.charAt(begin)]) has[S.charAt(begin)]--;
                    begin++;
                }
                // update minWindow if a minimum length is met
                int windowLen = end - begin + 1;
                if (windowLen < minWindowLen) {
                    minWindowBegin = begin;
                    minWindowEnd = end;
                    minWindowLen = windowLen;
                } 
            } 
        } 
        if(minWindowLen == Integer.MAX_VALUE) return "";
        return S.substring(minWindowBegin, minWindowEnd + 1);
    }
}