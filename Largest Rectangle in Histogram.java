/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int[] newh = new int[n + 1];
        for(int i = 0; i < n; i++) newh[i] = height[i];
        newh[n] = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n + 1; i++) {
            if(stack.empty() || newh[i] > newh[stack.peek()]) stack.push(i);
            else {
                int temp = stack.pop();
                max = Math.max(max, newh[temp] * (stack.empty() ? i : (i - stack.peek() - 1)));
                i--;
            }
        }
        return max;
    }
}