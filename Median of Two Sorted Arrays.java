/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/
//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html#comment-771
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A == null && B == null) return 0;
        if(A == null || A.length == 0) return singleArray(B);
        if(B == null || B.length == 0) return singleArray(A);
        return find(A, B, 0, A.length - 1, 0, B.length - 1);
    }
    public double singleArray(int[] A) {
        int len = A.length;
        int mid = len / 2;
        if(len != 2 * (len / 2)) return A[(len - 1) / 2];
        else return (A[mid - 1] + A[mid]) / 2.0;
    }
    public double doubleArray(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        int[] res = new int[alen + blen];
        int i = 0, j = 0, k = 0;
        while(i < alen || j < blen) {
            if(i < alen && (j >= blen || A[i] <= B[j])) {
                res[k] = A[i];
                i++;
            }
            else {
                res[k] = B[j];
                j++;
            }
            k++;
        }
        return singleArray(res);
    }
    public double find(int[] A, int[] B, int aleft, int aright, int bleft, int bright) {
        if(aright - aleft <= 1 || bright - bleft <= 1) return doubleArray(A, B);
        int amid = (aleft + aright) / 2;
        int bmid = (bleft + bright) / 2;
        if(A[amid] <= B[bmid]) {
            int k = Math.min(amid - aleft, bright - bmid);
            return find(A, B, aleft + k, aright, bleft, bright - k);
        }
        else {
            int k = Math.min(bmid - bleft, aright - amid);
            return find(A, B, aleft, aright - k, bleft + k, bright);
        }
    }
}