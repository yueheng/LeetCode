/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] num) {
        Arrays.sort(num);
        int len = 1;
        int max = 1;
        for(int i = 1; i < num.length; i++) {
            if(num[i] == num[i-1]) continue;
            if(num[i] == num[i-1] + 1) {
                len++;
            }
            else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max;
    }
}