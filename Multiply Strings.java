/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
public class Solution {
    public String multiply(String num1, String num2) {
        String res = "";
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return res;
        int l1 = num1.length();
        int l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];
        int[] n1n2 = new int[l1 + l2 - 1];
        for(int i = 0; i < l1; i++) n1[l1 - i - 1] = num1.charAt(i) - '0';
        for(int i = 0; i < l2; i++) n2[l2 - i - 1] = num2.charAt(i) - '0';
        for(int i = 0; i < l1; i++) {
            for(int j = 0; j < l2; j++) {
                n1n2[i + j] += n1[i] * n2[j];
            }
        }
        int adder = 0;
        for(int i = 0; i < l1 + l2 - 1; i++) {
            int curr = (n1n2[i] + adder) % 10;
            adder = (n1n2[i] + adder) / 10;
            res = String.valueOf(curr) + res;
        }
        while(adder > 0) {
            int curr = adder % 10;
            adder /= 10; 
            res = String.valueOf(curr) + res;
        }
        while(res.charAt(0) == '0' && res.length() > 1) {  // 999 * 0
            res = res.substring(1, res.length());
        }
        return res;
    }
}