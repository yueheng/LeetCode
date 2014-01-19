/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    public boolean search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while(low <= high) {
            int middle = (low + high) / 2;
            if(A[middle] == target) return true;
            if(A[low] < A[middle]) {
                if(A[low] <= target && target < A[middle]) high = middle - 1;
                else low = middle + 1;
            }
            else if(A[low] > A[middle]) {
                if(A[middle] < target && target <= A[high]) low = middle + 1;
                else high = middle - 1;
            }
            else low++;
        }
        return false;
    }
}