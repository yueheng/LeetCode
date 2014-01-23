/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null) return res;
        ArrayList<String> sub = new ArrayList<String>();
        helper(res, sub, 0, s);
        return res;
    }
    public void helper(ArrayList<ArrayList<String>> res, ArrayList<String> sub, int start, String s) {
        if(start == s.length()) {
            ArrayList<String> newSub = new ArrayList<String>(sub);
            res.add(newSub);
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(valid(s, start, i)) {
                String temp = s.substring(start, i+1);
                sub.add(temp);
                helper(res, sub, i+1, s);
                sub.remove(sub.size() - 1);
            }
        }
    }
    public boolean valid(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}