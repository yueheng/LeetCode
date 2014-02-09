/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.trim();
        return s.matches("(\\+|-)?(\\d+|\\d+\\.\\d*|\\d*\\.\\d+|(\\d+|\\.\\d+|\\d+\\.\\d*)e(\\+|-)?\\d+)");
    }
}