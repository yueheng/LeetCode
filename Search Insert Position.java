/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while(low < high) {
            int middle = (low + high) / 2;
            if(A[middle] == target) return middle;
            else if(A[middle] > target) high = middle -1;
            else low = middle + 1;
        }
        if(target > A[low]) return low + 1;
        else return low;
    }
}

public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0;
        for(; i < A.length; i++) {
            if(A[i] == target || A[i] > target) break;
        }
        return i;
    }
}