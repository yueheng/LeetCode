/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode temp = stack.pop();
            queue.add(temp);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        TreeNode prev = queue.remove();
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            prev.left = null;
            prev.right = temp;
            prev = temp;
        }
    }
}


public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(left != null) {
            root.right = left;
            root.left = null;
            TreeNode rightmost = left;
            while(rightmost.right != null) {rightmost = rightmost.right;}
            rightmost.right = right;
        }
        
        flatten(root.right);
    }
    
}