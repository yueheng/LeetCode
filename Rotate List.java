/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode temp = head, first = head, second = head;
        ListNode res = null;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        n %= len;
        if(n == 0) return head;
        while(n > 0) {
            first = first.next;
            n--;
        }
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        res = second.next;
        second.next = null;
        first.next = head;
        return res;
    }
}