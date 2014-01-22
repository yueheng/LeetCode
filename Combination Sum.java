/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null) return res;
        Arrays.sort(candidates);
        ArrayList<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, candidates, target, 0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub, int[] candidates, int target, int start) {
        if(target == 0) {
            ArrayList<Integer> newSub = new ArrayList<Integer>(sub);
            if(!res.contains(newSub)) res.add(newSub);
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                sub.add(candidates[i]);
                helper(res, sub, candidates, target - candidates[i], i);
                sub.remove(sub.size() - 1);
            }
        }
    }
}