/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int[] bucket = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            bucket[s1.charAt(i) - 'a'] += 1;
            bucket[s2.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < s1.length(); i++) {
            if(bucket[i] != 0) return false;
        }
        String s11, s12, s21, s22;
        for(int i = 1; i < s1.length() ; i++) {
            s11 = s1.substring(0, i);
            s12 = s1.substring(i, s1.length());
            s21 = s2.substring(0, i);
            s22 = s2.substring(i, s1.length());
            if(isScramble(s11, s21) == true && isScramble(s12, s22) == true) return true;
            
            s21 = s2.substring(s1.length() - i, s1.length());
            s22 = s2.substring(0, s1.length() - i);
            if(isScramble(s11, s21) == true && isScramble(s12, s22) == true) return true;
        }
        return false;
    }
}