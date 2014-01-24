/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null) return res;
        Arrays.sort(num);
        ArrayList<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, num, 0, target);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub, int[] num, int start, int sum) {
        if(sum == 0) {
            if(!res.contains(sub)) {
                ArrayList<Integer> newSub = new ArrayList<Integer>(sub);
                res.add(newSub);
            }
            return;
        }
        if(sum < 0) return;
        for(int i = start; i < num.length; i++) {
            sub.add(num[i]);
            helper(res, sub, num, i+1, sum - num[i]);
            sub.remove(sub.size() - 1);
        }
    }
}