/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i = m;
        while(i > 1) {
            prev = prev.next;
            i--;
        }
        ListNode curr = prev.next;
        ListNode next = curr.next;
        ListNode last = curr;
        while(n > m) {
            ListNode temp = next;
            next = next.next;
            prev.next = temp;
            temp.next = curr;
            curr = temp;
            n--;
        }
        last.next = next;
        return dummy.next;
    }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for(int i = 1; i <= n; i++) {
            if(i == m) second = first;
            if(i > m && i <= n) {
                first.next = head.next;
                head.next = second.next;
                second.next = head;
                head = first;
            }
            first = head;
            head = head.next;
        }
        return dummy.next;
    }
}