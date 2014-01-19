/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Discuss
*/
public class Solution {
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(A[middle] == target) return middle;
            if(A[low] <= A[middle]) { //left is sorted
                if(A[low] <= target && target < A[middle]) high = middle - 1;
                else low = middle + 1;
            }
            else { //right is sorted
                if(A[middle] < target && target <= A[high]) low = middle + 1;
                else high = middle - 1;
            }
        }
        return -1;
    }
}