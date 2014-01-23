/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode helper(int[] in, int start1, int end1, int[] post, int start2, int end2) {
        if(start1 > end1 || start2 > end2) return null;
        int val = post[end2];
        TreeNode res = new TreeNode(val);
        int i = start1;
        for(; i <= end1; i++) if(in[i] == val) break;
        res.left = helper(in, start1, i-1, post, start2, start2-start1+i-1);
        res.right = helper(in, i+1, end1, post, start2-start1+i, end2-1);
        return res;
    }
}