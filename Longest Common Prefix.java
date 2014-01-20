/*
Write a function to find the longest common prefix string amongst an array of strings.
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return new String("");
        int right = strs[0].length() - 1;
        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j <= right; j++) {
                if(strs[i].length() - 1 < j || strs[0].charAt(j) != strs[i].charAt(j)) right = j - 1;
            }
        }
        return strs[0].substring(0, right + 1);
    }
}