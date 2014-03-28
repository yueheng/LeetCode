/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        String sub = "";
        helper(res, sub, s, dict);
        return res;
    }
    public void helper(ArrayList<String> res, String sub, String s, Set<String> dict) {
        if(s == null) return;
        if(s.length() == 0) {
            if(!res.contains(sub))res.add(sub);
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            if(dict.contains(s.substring(0, i))) {
                if(sub.length() == 0) helper(res, s.substring(0, i) , s.substring(i, s.length()), dict);
                else helper(res, sub + " " + s.substring(0, i) , s.substring(i, s.length()), dict);
            }
        }
    }
}