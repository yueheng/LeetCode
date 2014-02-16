/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        res.add(sub);
        if(num == null) return res;
        for(int i = 0; i < num.length; i++) {
            int size = res.size();
            for(int j = 0; j < size; j++) {
                ArrayList<Integer> temp = res.get(0);
                res.remove(temp);
                for(int k = 0; k <= temp.size(); k++) {
                    ArrayList<Integer> newsub = new ArrayList<Integer>(temp);
                    newsub.add(k, num[i]);
                    res.add(newsub);
                }
            }
        }
        return res;
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return res;
        helper(res, 0, num);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, int pos, int[] num) {
        if(pos == num.length) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            res.add(sub);
            return;
        }
        helper(res, pos + 1, num);
        int size = res.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> temp = res.remove(0);
            for(int j = 0; j <= temp.size(); j++) {
                ArrayList<Integer> sub = new ArrayList<Integer>(temp);
                sub.add(j, num[pos]);
                res.add(sub);
            }
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null) return res;
        helper(num, 0, res);
        return res;
    }
    
    public void helper(int[] num, int pos, ArrayList<ArrayList<Integer>> res) {
        if(pos == num.length - 1) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(num[pos]);
            res.add(sub);
            return;
        }
        helper(num, pos + 1, res);
        int size = res.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> temp = res.get(i);
            for(int j = 0; j < temp.size(); j++) {
                ArrayList<Integer> newSub = new ArrayList<Integer>(temp);
                newSub.add(j, num[pos]);
                res.add(newSub);
            }
            temp.add(num[pos]);
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subRes = new ArrayList<Integer>();
        res.add(subRes);
        helper(num, res);
        return res;
    }
   public void helper (int[] num, ArrayList<ArrayList<Integer>> res) {
        for(int i = 0; i < num.length; i++) {
            int resSize = res.size();
            for(int k = 0; k < resSize; k++) {
                ArrayList<Integer> subRes = res.get(k);
                boolean first = true;
                for(int j = 0; j < num.length; j++) {
                    if(!subRes.contains(num[j])) {
                        if(first == true) {
                            subRes.add(num[j]);
                            first = false;
                        }
                        else {                            
                            ArrayList<Integer> newSub = new ArrayList<Integer>(subRes);
                            newSub.remove(i);
                            newSub.add(num[j]);
                            res.add(newSub);
                        }
                    } 
                }
            }
        }
    }
}