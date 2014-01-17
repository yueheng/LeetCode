/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode second = head;
        ListNode first = head.next;
        while(first != null) {
            if(first == second) break;
            if(first.next == null) return null;
            first = first.next.next;
            second = second.next;
        }
        if(first == null) return null;
        first = first.next;
        while(true) {
            if(first == head) return first;
            first = first.next;
            head = head.next;
        }
    }
}