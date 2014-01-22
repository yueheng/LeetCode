/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    public ArrayList<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) res.add(null);
        for(int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generate(start, i - 1);
            ArrayList<TreeNode> right = generate(i + 1, end);
            for(int j = 0; j < left.size(); j++) {
                for(int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}