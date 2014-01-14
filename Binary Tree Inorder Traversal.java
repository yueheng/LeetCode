/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].
*/
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(true) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                if(stack.empty()) break;
                TreeNode temp = stack.pop();
                res.add(temp.val);
                curr = temp.right;
            }
        }
        return res;
    }
}

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
    
    public void helper(ArrayList<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}