/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            while(!curr.isEmpty()) {
                TreeNode temp = curr.remove();
                sub.add(temp.val);
                if(temp.left != null) next.add(temp.left);
                if(temp.right != null) next.add(temp.right);
            }
            res.add(sub);
            Queue<TreeNode> temp = next;
            next = curr;
            curr = temp;
        }
        return res;
    }
}