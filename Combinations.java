/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, n, k, 1);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub, int n, int k, int start) {
        if(k == 0) {
            ArrayList<Integer> newsub = new ArrayList<Integer>(sub);
            res.add(newsub);
            return;
        }
        for(int i = start; i <= n-k+1; i++) {
            sub.add(i);
            helper(res, sub, n, k-1, i+1);
            sub.remove(sub.size() - 1);
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subRes = new ArrayList<Integer>();
        res.add(subRes);
        helper(n, k, res);
        return res;
    }
    public void helper(int n, int k, ArrayList<ArrayList<Integer>> res) {
        for(int i = 0; i < k; i++) {
            int resSize = res.size();
            for(int j = 0; j < resSize; j++) {
                ArrayList<Integer> subRes = res.get(j);
                boolean first = true;
                int currMax = 0;
                if(subRes.size() != 0) currMax = subRes.get(i - 1);
                for(int m = 1; m <= n; m++) {
                    if(m <= currMax) continue;
                    if(n - m + 1 < k - i) continue;
                    if(first == true) {
                            subRes.add(m);
                            first = false;
                    }
                    else {
                            ArrayList<Integer> newSub = new ArrayList<Integer>(subRes);
                            newSub.remove(i);
                            newSub.add(m);
                            res.add(newSub);
                    }
                }
            }
        }
    }
}