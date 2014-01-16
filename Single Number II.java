/*
Single Number II Total Accepted: 6420 Total Submissions: 20554 My Submissions
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) return 0;
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(count.get(A[i]) == null) count.put(A[i], 1);
            else count.put(A[i], Integer.valueOf(count.get(A[i]).intValue() + 1));
        }
        for(int i = 0; i < A.length; i++) {
            if(count.get(A[i]) != 3) return A[i];
        }
        return A[0];
    }
}


//Hard
public class Solution {
    public int singleNumber(int[] A) {
        int sum1 = 0;
         int sum2 = 0;
         int not_sum3 = 0;
         for(int i=0; i<A.length; i++ )
         {
             // store duplicated number at the second time
             // so it occurs both in sum1 and A[i]
             sum2 |= sum1 & A[i];
 
             // duplicated number would be removed at the second time
             sum1 ^= A[i];
 
             // when duplicated number occurs at the third time
             // it occurs both in sum1 and sum2
             not_sum3 = ~(sum1 & sum2) ;
 
             // so, remove the same part both in sum1 and sum2
             // it means remove duplicated number at the third time
             sum1 &= not_sum3 ;
             sum2 &= not_sum3 ;
         }
 
         return sum1;
    }
}