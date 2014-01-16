/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null && head.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int tempInt = temp.val;
            temp.val = temp.next.val;
            temp.next.val = tempInt;
            if(temp.next != null) temp = temp.next.next;
            else break;
        }
        return head;
    }
}