/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, len = 0, n = s.length();
        boolean[] exist = new boolean[256];
        while(j < n) {
            if(exist[s.charAt(j)] == true) {
                len = Math.max(len, j - i);
                while(s.charAt(i) != s.charAt(j)) {
                    exist[s.charAt(i)] = false;
                    i++;
                }
                i++;
            }
            else {
                exist[s.charAt(j)] = true;
            }
            j++;
        }
        len = Math.max(len, n - i);
        return len;
    }
}