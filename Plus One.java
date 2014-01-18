/*
Given a number represented as an array of digits, plus one to the number.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null) return null;
        Stack<Integer> stack = new Stack<Integer>();
        int adder = 1;
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            int temp = digits[i] + adder;
            if(temp >= 10) {
                temp -= 10;
                adder = 1;
            }
            else adder = 0;
            stack.push(temp);
        }
        int[] res;
        int i = 0;
        if(adder == 1) {
            res = new int[n + 1];
            res[0] = 1;
            i++;
        }
        else res = new int[n];
        while(!stack.empty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}