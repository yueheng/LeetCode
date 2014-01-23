/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null) return res;
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String sub = "";
        res.add(sub);
        for(int i = 0; i < digits.length(); i++) {
            int pos = digits.charAt(i) - '2';
            String str = letters[pos];
            int size = res.size();
            for(int j = 0; j < size; j++) {
                String temp = res.remove(0);
                for(int k = 0; k < str.length(); k++) {
                    String newSub = temp + String.valueOf(str.charAt(k));
                    res.add(newSub);
                }
            }
        }
        return res;
    }
}


public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        String sub = "";
        helper(digits, sub, res, 0);
        return res;
    }
    public void helper(String digits, String sub, ArrayList<String> res, int step) {
        if(sub.length() == digits.length()) {
            String newSub = new String(sub);
            res.add(newSub);
            return;
        }        
        String toChar = dToC(digits.charAt(step));
        for(int i = 0; i < toChar.length(); i++) {
            helper(digits, sub + toChar.charAt(i), res, step + 1);
        }        
    }    
    public String dToC(char d) {
        String res = "";
        if(d == '2') res = "abc";
        else if(d == '3') res = "def";
        else if(d == '4') res = "ghi";
        else if(d == '5') res = "jkl";
        else if(d == '6') res = "mno";
        else if(d == '7') res = "pqrs";
        else if(d == '8') res = "tuv";
        else if(d == '9') res = "wxyz";
        return res;
    }
}