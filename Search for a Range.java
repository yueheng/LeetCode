/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
   public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        if(A == null || A.length == 0) return res;
        int low = 0, high = A.length - 1;
        while(low < high) {      //lower bound
            int middle = (low + high) / 2;
            if(A[middle] < target) low = middle + 1;
            else high = middle;
        }
        if(A[low] != target) return res;
        res[0] = low;
        high = A.length - 1;
        while(low < high) {     //higher bound
            int middle = (low + high + 1) / 2;
            if(A[middle] > target) high = middle - 1;
            else low = middle;
        }
        res[1] = high;
        return res;
    }
}