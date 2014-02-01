/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "a*") ¡ú true
isMatch("aa", ".*") ¡ú true
isMatch("ab", ".*") ¡ú true
isMatch("aab", "c*a*b") ¡ú true
Discuss
*/
/*
If the next character of p is NOT '*', then it must match the current character of s. 
Continue pattern matching with the next character of both s and p.
If the next character of p is '*', then we do a brute force exhaustive matching of 0, 1, 
or more repeats of current character of p... Until we could not match any more characters.
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null) return s == null;
        if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1 || p.charAt(1) != '*') {   // next char is not '*': must match current character
            if(s.length() == 0) return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
        }
        while(s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {   // next char is '*'
            if(isMatch(s, p.substring(2, p.length())) == true) return true;
            s = s.substring(1, s.length());
        }
        return isMatch(s, p.substring(2, p.length()));
    }
}