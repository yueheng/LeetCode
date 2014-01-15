public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char next = 'N';
            if(i < s.length() - 1) next = s.charAt(i + 1);
            int toSum = helper(c, next);
            if(toSum == 4 || toSum == 9
                || toSum == 40 || toSum == 90
                || toSum == 400 || toSum == 900) i++;
            res += toSum;
        }
        return res;
    }
    public int helper(char c, char next) {
        if(c == 'M') return 1000;
        else if(c == 'D') return 500;
        else if(c == 'C') {
            if(next == 'D') return 400;
            else if(next == 'M') return 900;
            else return 100;
        }
        else if(c == 'L') return 50;
        else if(c == 'X') {
            if(next == 'L') return 40;
            else if(next == 'C') return 90;
            else return 10;
        }
        else if(c == 'V') return 5;
        else if(c == 'I') {
            if(next == 'V') return 4;
            else if(next == 'X') return 9;
            else return 1;
        }
        else return 0;
    }
}