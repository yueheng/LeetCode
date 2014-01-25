/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int nRows) {
        if(nRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < nRows; i++) {
            int j = i;
            while(j < n) {
                res.append(String.valueOf(s.charAt(j)));
                if(i != 0 && i != nRows - 1) {
                    int k = j + (nRows - i - 1) * 2;
                    if(k < n) res.append(String.valueOf(s.charAt(k)));
                }
                j += (nRows - 1) * 2;
            }
        }
        return res.toString();
    }
}