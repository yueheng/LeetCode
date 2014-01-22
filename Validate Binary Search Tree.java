/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Queue<Integer> q = new LinkedList<Integer>();
        TreeNode curr = root;
        while(true) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            else {
                if(s.empty()) break;
                TreeNode temp = s.pop();
                q.add(temp.val);
                curr = temp.right;
            }
        }
        int prev = q.remove();
        while(!q.isEmpty()) {
            int currNum = q.remove();
            if(prev >= currNum) return false;
            prev = currNum;
        }
        return true;
    }
}


public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int low, int high) {
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}