/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
*/
public class Solution {
    ArrayList<TreeNode> error = new ArrayList<TreeNode>();
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = error.get(0).val;
        error.get(0).val = error.get(error.size() - 1).val;
        error.get(error.size() - 1).val = temp;
    }
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val > root.val) {
            if(!error.contains(prev)) error.add(prev);
            if(!error.contains(root))error.add(root);
        } 
        prev = root;
        inorder(root.right);
    }
}