/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        return helper(num, 0, num.length - 1);
    }
    
    public TreeNode helper(int[] num, int start, int end) {
        if(start > end) return null;
        int middle = (start + end) / 2;
        TreeNode res = new TreeNode(num[middle]);
        res.left = helper(num, start, middle - 1);
        res.right = helper(num, middle + 1, end);
        return res;
    }
}