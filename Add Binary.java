/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = a.length() - 1;
        int j = b.length() - 1;
        int adder = 0;
        String res = "";
        while(i >= 0 || j >= 0 || adder > 0) {
            int temp = adder;
            if(i >= 0) temp += (a.charAt(i) - '0');
            if(j >= 0) temp += (b.charAt(j) - '0');
            adder = temp / 2;
            temp %= 2;
            res = String.valueOf(temp) + res;
            i--;
            j--;
        }
        return res;
    }
}