/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        curr.add(root);
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        while(!curr.isEmpty()) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            while(!curr.isEmpty()) {
                TreeNode temp = curr.remove();
                sub.add(temp.val);
                if(temp.left != null) next.add(temp.left);
                if(temp.right != null) next.add(temp.right);
            }
            res.add(0, sub);
            Queue<TreeNode> temp = next;
            next = curr;
            curr = temp;
        }
        return res;
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Stack<ArrayList<Integer>> resultStack = new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
        trees.add(root);
        int currTreeNum = 1;
        
        while(!trees.isEmpty()) {
            ArrayList<Integer> subResult = new ArrayList<Integer>();
            int nextTreeNum = 0;
            while(currTreeNum > 0) {
                subResult.add(trees.get(0).val);
                if(trees.get(0).left != null) {
                    trees.add(trees.get(0).left);
                    nextTreeNum++;
                }
                if(trees.get(0).right != null) {
                    trees.add(trees.get(0).right);
                    nextTreeNum++;
                } 
                trees.remove(0);
                currTreeNum--;
            }
            if(subResult != null) resultStack.push(subResult);
            currTreeNum = nextTreeNum;
        }
        
        while(!resultStack.empty()) {
            result.add(resultStack.pop());
        }
        return result;
    }
}