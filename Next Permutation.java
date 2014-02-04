/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
*/
/*
1. Find the one that's descending, if every number is in ascending order, reorder it and return
2. Find the smallest number that's after the first descending number
3. swap these two number
4. reorder number after the descending number
*/
public class Solution {
    public void nextPermutation(int[] num) {
        int i = num.length - 2;
        for(; i >= 0; i--) {
            if(num[i] < num[i+1]) break;
        }
        if(i < 0) {
            Arrays.sort(num);
            return;
        }
        int min = i+1;
        for(int j = i+1; j < num.length; j++) {
            if(num[i] < num[j] && num[j] < num[min]) min = j;
        }
        int temp = num[i];
        num[i] = num[min];
        num[min] = temp;
        Arrays.sort(num, i+1, num.length);
    }
}