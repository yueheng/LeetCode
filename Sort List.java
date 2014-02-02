/*
Sort a linked list in O(n log n) time using constant space complexity.
*/
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        len /= 2;
        temp =  head;
        while(len > 1) {
            temp = temp.next;
            len--;
        }
        ListNode left = head, right = temp.next, newHead = null;
        temp.next = null;
        left = sortList(left);
        right = sortList(right);
        while(left != null && right != null) {
            if(left.val < right.val) {
                if(newHead == null) newHead = left;
                else temp.next = left;
                temp = left;
                left = left.next;
            }
            else {
                if(newHead == null) newHead = right;
                else temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        while(left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }
        while(right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }
        return newHead;
    }
}