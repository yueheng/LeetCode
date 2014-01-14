/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

//Iterative
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode a = queue.remove();
            TreeNode b = queue.remove();
            if(a == null && b == null) continue;
            else if(a != null && b != null) {
                if(a.val != b.val) return false;
                queue.add(a.left);
                queue.add(b.right);
                queue.add(a.right);
                queue.add(b.left);
                continue;
            }
            return false;
        }
        return true;
    }
}

//Recersive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode a, TreeNode b) {
        if(a == null) return b == null;
        if(b == null) return false;
        if(a.val != b.val) return false;
        return helper(a.right, b.left) && helper(a.left, b.right);
    }
}