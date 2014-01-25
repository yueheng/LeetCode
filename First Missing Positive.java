/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0) return 1;
        for(int i = 0; i < A.length; i++) {
            int pos = A[i] - 1;
            if(pos >= 0 && pos < A.length && pos != i && A[pos] != A[i]) {
                int temp = A[i];
                A[i] = A[pos];
                A[pos] = temp;
                i--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] - 1 != i) return i+1;
        }
        return A.length + 1;
    }
}