/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        String res = "";
        while(num > 0) {
            if(num - 1000 >= 0) {
                res += "M";
                num -= 1000;
            }
            else if (num - 900 >= 0) {
                res += "CM";
                num -= 900;
            }
            else if (num - 500 >= 0) {
                res += "D";
                num -= 500;
            }
            else if (num - 400 >= 0) {
                res += "CD";
                num -= 400;
            }
            else if (num - 100 >= 0) {
                res += "C";
                num -= 100;
            }
            else if (num - 90 >= 0) {
                res += "XC";
                num -= 90;
            }
            else if (num - 50 >= 0) {
                res += "L";
                num -= 50;
            }
            else if (num - 40 >= 0) {
                res += "XL";
                num -= 40;
            }
             else if (num - 10 >= 0) {
                res += "X";
                num -= 10;
            }
            else if (num - 9 >= 0) {
                res += "IX";
                num -= 9;
            }
            else if (num - 5 >= 0) {
                res += "V";
                num -= 5;
            }
            else if (num - 4 >= 0) {
                res += "IV";
                num -= 4;
            }
            else if (num - 1 >= 0) {
                res += "I";
                num -= 1;
            }
        }
        return res;
    }
}