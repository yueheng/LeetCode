/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int first = 1, second = 1, next;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                if(s.charAt(i) == '0') next = first;
                else next = first + second;
            }
            else {
                if(s.charAt(i) != '0') next = second;
                else return 0;
            }
            first = second;
            second = next;
        }
        return second;
    }
}