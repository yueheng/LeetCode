/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(res, root);
        return res;
    }
    public void helper(ArrayList<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode curr = null, prev = null;
        while(!stack.empty()) {
            curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr) {
                if(curr.left != null) stack.push(curr.left);
                else if(curr.right != null) stack.push(curr.right);
                else res.add(stack.pop().val);
            }
            else if(curr.left == prev) {
                if(curr.right != null) stack.push(curr.right);
                else res.add(stack.pop().val);
            }
            else if(curr.right == prev) res.add(stack.pop().val);
            prev = curr;
        }
        return res;
    }
    
}