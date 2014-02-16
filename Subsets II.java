/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> sub = new ArrayList<Integer>();
       res.add(sub);
       if(num == null) return res;
       Arrays.sort(num);
       for(int i = 0; i < num.length; i++) {
           int size = res.size();
           for(int j = 0; j < size; j++) {
               ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
               temp.add(num[i]);
               if(!res.contains(temp))res.add(temp);
           }
       }
       return res;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null) return res;
        Arrays.sort(num);
        helper(res, num, 0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, int[] num, int pos) {
        if(pos == num.length) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            res.add(sub);
            return;
        }
        helper(res, num, pos + 1);
        int size = res.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> sub = new ArrayList<Integer>(res.get(i));
            sub.add(0, num[pos]);
            if(!res.contains(sub)) res.add(sub);
        }
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
         Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subRes = new ArrayList<Integer>();
        res.add(subRes);
        int start = 0;
        for(int i = 0; i < num.length; i++) {
            int resSize = res.size();
            for(int j = start; j < resSize; j++) {
                ArrayList<Integer> temp = res.get(j);
                ArrayList<Integer> newSub = new ArrayList<Integer>(temp);
                newSub.add(num[i]);
                res.add(newSub);
            }
            if(i < num.length - 1 && num[i + 1] == num[i]) start = resSize;
            else start = 0;
        }
        return res;
    }
}