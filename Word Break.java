/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null) return false;
        int n = s.length();
        boolean[] valid = new boolean[n+1];
        valid[0] = true;
        for(int i = 1; i < n+1; i++) {
            for(int j = 0; j < i; j++) {
                if(valid[j] && dict.contains(s.substring(j, i))) valid[i] = true;
            }
        }
        return valid[n];
    }
}