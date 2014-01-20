/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int res = 0;
        while(low < high) {
            if(A[low] < A[high]) {
                int next = low + 1;
                while(next < A.length && A[low] > A[next]) {
                    res += A[low] - A[next];
                    next++;
                }
                low = next;
            }
            else {
                int next = high - 1;
                while(next >=0 && A[high] > A[next]) {
                    res += A[high] - A[next];
                    next--;
                }
                high = next;
            }
        }
        return res;
    }
}