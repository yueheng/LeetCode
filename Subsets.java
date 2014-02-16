/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> sub = new ArrayList<Integer>();
       res.add(sub);
       if(S == null) return res;
       Arrays.sort(S);
       for(int i = 0; i < S.length; i++) {
           int size = res.size();
           for(int j = 0; j < size; j++) {
               ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
               temp.add(S[i]);
               res.add(temp);
           }
       }
       return res;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null) return res;
        Arrays.sort(S);
        helper(res, S, 0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, int[] S, int pos) {
        if(pos == S.length) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            res.add(sub);
            return;
        }
        helper(res, S, pos + 1);
        int size = res.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> temp = res.get(i);
            if(temp.contains(S[pos])) continue;
            ArrayList<Integer> sub = new ArrayList<Integer>(temp);
            sub.add(0, S[pos]);
            res.add(sub);
        }
    }
}



public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subRes = new ArrayList<Integer>();
        res.add(subRes);
        int lastResSize = 0;
        for(int i = 0; i < S.length; i++) {
            if(i != 0 && S[i] == S[i - 1]) continue;
            int resSize = res.size();
            for(int j = lastResSize; j < resSize; j++) {
                ArrayList<Integer> temp = res.get(j);
                for(int k = 0; k < S.length; k++) {
                    if(k != 0 && S[k] == S[k - 1]) continue;
                    if(temp.size() == 0 ||  S[k] > temp.get(temp.size() - 1)) {
                        ArrayList<Integer> newSub = new ArrayList<Integer>(temp);
                        newSub.add(S[k]);
                        res.add(newSub);
                    }
                }
            }
            lastResSize = resSize;
        }
        return res;
    }
}