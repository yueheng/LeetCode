/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null) {
            boolean skip = false;
            while(curr.next != null) {
                if(curr.val == curr.next.val) {
                    skip = true;
                    curr = curr.next;
                }
                else break;
            }
            if(skip == true) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}