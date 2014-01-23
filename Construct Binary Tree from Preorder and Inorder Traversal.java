/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] pre, int start1, int end1, int[] in, int start2, int end2) {
        if(start1 > end1 || start2 > end2) return null;
        int val = pre[start1];
        TreeNode res = new TreeNode(val);
        int i = start2;
        for(; i <= end2; i++) if(in[i] == val) break;
        res.left = helper(pre, start1 + 1, start1-start2+i, in, start2, i-1);
        res.right = helper(pre, start1-start2+i+1, end1, in, i+1, end2);
        return res;
    }
}