/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) stack.add(root);
        while(!stack.empty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return res;
    }
}


public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
    
    public void helper(ArrayList<Integer> res, TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}