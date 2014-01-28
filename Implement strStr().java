/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle == null) return null;
        if(needle.length() == 0) return haystack;
        int len = needle.length();
        for(int i = 0; i < haystack.length() - len + 1; i++) {
            if(haystack.substring(i, i + len).equals(needle)) return haystack.substring(i, haystack.length());
        }
        return null;
    }
}