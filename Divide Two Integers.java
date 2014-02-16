/*
Divide two integers without using multiplication, division and mod operator.
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        int mask = 1;
        if(dividend < 0) mask *= -1;
        if(divisor < 0) mask *= -1;
        long a = Math.abs((long)dividend); //For int, from -2147483648 to 2147483647, inclusive
        long b = Math.abs((long)divisor);
        long res = 0;
        while(a >= b) {
            long c = b;
            for(int i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                res += 1 << i;
            }
        }
        return mask > 0 ? (int)res : -(int)res;
    }