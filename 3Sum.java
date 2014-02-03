/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null) return res;
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++) {
            if(i > 0 && num[i] == num[i-1]) continue;
            int j = i + 1;
            int k = num.length - 1;
            while(j < k) {
                int temp = num[i] + num[j] + num[k];
                if(temp < 0) j++;
                else if(temp > 0) k--;
                else {
                    ArrayList<Integer> sub = new ArrayList<Integer>();
                    sub.add(num[i]);
                    sub.add(num[j]);
                    sub.add(num[k]);
                    res.add(sub);
                    do{j++;} while(j < k && num[j] == num[j-1]);
                    do{k--;} while(k > j && num[k] == num[k+1]);
                }
            }
        }
        return res;
    }
}