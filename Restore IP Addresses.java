/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        String sub = "";
        helper(res, sub, s, 4);
        return res;
    }
    public void helper(ArrayList<String> res, String sub, String s, int k) {
        if(k == 0) {
            if(s.length() == 0) res.add(sub);
            return;
        }
        for(int i = 1; i <= s.length() && i <= 3; i++) {
            String temp = s.substring(0, i);
            if(valid(temp)) {
                if(k == 1) helper(res, sub + temp, s.substring(i, s.length()), 0);
                else helper(res, sub + temp + ".", s.substring(i, s.length()), k-1);
            }
        }
    }
    public boolean valid(String str) {
        int temp = Integer.parseInt(str);
        if(temp > 255) return false;
        if((temp < 10 && str.length() > 1) || (temp < 100 && str.length() > 2)) return false;
        return true;
    }
}