/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        return helper(head, 0, len - 1);
    }
    public TreeNode helper(ListNode head, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = helper(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if(head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
            root.right = helper(head, mid + 1, end);
        }
        return root;
    }
}