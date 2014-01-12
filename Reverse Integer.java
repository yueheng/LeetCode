/*
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int r = 0;
        while(x != 0) {
            r = r*10 + x%10;
            x = x/10;
        }
        return r;
    }
}

public class Solution {
    public int reverse(int x) {
        int res = 0;
        int temp = Math.abs(x);
        while(temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return x > 0 ? res : -res;
    }
}