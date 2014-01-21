/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Solution {
    public boolean canJump(int[] A) {
        if(A == null) return false;
        int n = A.length;
        int reach = 1;
        for(int i = 0; i < reach && reach < n; i++) {
            reach = Math.max(reach, A[i] + i + 1);
        }
        return reach >= n;
    }
}