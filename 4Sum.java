/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) return res;
        Arrays.sort(num);
        int n = num.length;
        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && num[i] == num[i-1]) continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && num[j] == num[j - 1]) continue;
                int start = j + 1; 
                int end = n - 1;
                while(start < end) {
                    int temp = num[i] + num[j] + num[start] + num[end];
                    if(temp < target) start++;
                    else if(temp > target) end--;
                    else {
                        ArrayList<Integer> sub = new ArrayList<Integer>();
                        sub.add(num[i]);
                        sub.add(num[j]);
                        sub.add(num[start]);
                        sub.add(num[end]);
                        res.add(sub);
                        do{start++;} while(start < end && num[start] == num[start-1]);
                        do{end--;} while(start < end && num[end] == num[end + 1]);
                    }
                }
            }
        }
        return res;
    }
}