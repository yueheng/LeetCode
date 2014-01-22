/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> curr = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        curr.push(root);
        boolean left2right = false;
        while(!curr.empty()) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            while(!curr.empty()) {
                TreeNode temp = curr.pop();
                sub.add(temp.val);
                if(left2right == false) {
                    if(temp.left != null) next.push(temp.left);
                    if(temp.right != null) next.push(temp.right);
                }
                else {
                    if(temp.right != null) next.push(temp.right);
                    if(temp.left != null) next.push(temp.left);
                }
            }
            res.add(sub);
            if(left2right == true) left2right = false;
            else left2right = true;
            Stack<TreeNode> temp = curr;
            curr = next;
            next = temp;
        }
        return res;
    }
}