/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

/*
 f(n) = f(n-1) + f(n-2), which is the exact same recurrence formula defined by the Fibonacci sequence 
 f(n) = C(n,0) + C(n-1,1) + C(n-2,2) + ... + C(ceiling(n/2), floor(n/2))
*/


public class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i++) {
            int c = a + b; 
            a = b;
            b = c;
        }
        return b;
    }
}