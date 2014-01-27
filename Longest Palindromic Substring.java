/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String temp1 = helper(i, i, s);
            if(temp1.length() > res.length()) res = temp1;
            String temp2 = helper(i, i+1, s);
            if(temp2.length() > res.length()) res = temp2;
        }
        return res;
    }
    public String helper(int left, int right, String s) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}