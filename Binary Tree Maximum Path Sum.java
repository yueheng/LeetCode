/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = root == null ? 0 : root.val;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0), right = Math.max(helper(root.right), 0);
        max = Math.max(root.val + left + right, max);
        return root.val + Math.max(left, right);
    }
}