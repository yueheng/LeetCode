/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null) return res;
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        ArrayList<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, num, visited);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub, int[] num, boolean[] visited) {
        if(sub.size() == num.length) {
            ArrayList<Integer> newSub = new ArrayList<Integer>(sub);
            res.add(newSub);
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(visited[i] == true || (i > 0 && num[i] == num[i - 1] && visited[i-1] == false)) continue;
            visited[i] = true;
            sub.add(num[i]);
            helper(res, sub, num, visited);
            sub.remove(sub.size() - 1);
            visited[i] = false;
        }
    }
}