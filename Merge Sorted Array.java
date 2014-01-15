/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int curr = m + n - 1;
        while(m - 1 >= 0 && n - 1 >= 0) {
            if(A[m - 1] > B[n - 1]) {
                A[curr] = A[m - 1];
                m--;
            }
            else {
                A[curr] = B[n - 1];
                n--;
            }
            curr--;
        }
        while(m - 1 >= 0) {
            A[curr] = A[m - 1];
            m--;
            curr--;
        }
        while(n - 1 >= 0) {
            A[curr] = B[n - 1];
            n--;
            curr--;
        }
    }
}


public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int curr = m+n-1;
        int i = m - 1;
        int j = n - 1;
        for(; curr >= 0;curr--) {
            if(i >= 0 && j >= 0) {
                if(A[i] > B[j]) {
                    A[curr] = A[i];
                    i--;
                }
                else {
                    A[curr] = B[j];
                    j--;
                }
            }
            else if(j < 0 && i >= 0) {
                A[curr] = A[i];
                i--;
            }
            else if(i < 0 && j >= 0){
                A[curr] = B[j];
                j--;
            }
        }
    }
}