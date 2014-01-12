/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode first = head.next;
        ListNode second = head;
        while(first != null) {
            if(first == second) return true;
            if(first.next != null) first = first.next.next;
            else return false;
            second = second.next;
        }
        return false;
    }
}