/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in 
which the depth of the two subtrees of every node never differ by more than 1.
*/

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftDepth - rightDepth) <= 1;
    }    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return true;
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);        
    }    
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return Math.max(getHeight(node.left) + 1, getHeight(node.right) + 1);
    }
}