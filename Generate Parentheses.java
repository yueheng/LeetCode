/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n <= 0) return res;
        String sub = "";
        helper(res, sub, 0, 0, n);
        return res;
    }
    
    public void helper(ArrayList<String> res, String sub, int left, int right, int n) {
        if(left == n) {
            for(int i = right + 1; i <= n; i++) {
                sub += ")";
            }
            res.add(sub);
            return;
        }
        helper(res, sub + "(", left + 1, right, n);
        if(left > right) helper(res, sub + ")", left, right + 1, n);
    }
}