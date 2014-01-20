/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        helper(res, sub, root, sum);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sub, TreeNode root, int sum) {
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                ArrayList<Integer> newSub = new ArrayList<Integer>(sub);
                newSub.add(root.val);
                res.add(newSub);
            }
            return;
        }
        sub.add(root.val);
        if(root.left != null) helper(res, sub, root.left, sum - root.val);
        if(root.right != null) helper(res, sub, root.right, sum - root.val);
        sub.remove(sub.size() - 1);
    }
}