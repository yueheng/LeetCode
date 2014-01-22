/*
Sort a linked list using insertion sort.
*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode pre = res;
        ListNode curr = null;
        ListNode next;
        while(head != null) {
            next = head;
            head = head.next;
            next.next = null;
            pre = res;
            curr = pre.next;
            while(curr != null && curr.val < next.val) {
                curr = curr.next;
                pre = pre.next;
            }
            pre.next = next;
            next.next = curr;
        }
        return res.next;
    }
}


public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode temp =head;
        head = head.next;
        temp.next = null;
        while(head != null) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            while(curr != null) {
                if(head.val < curr.val) {
                    prev.next = head;
                    temp = head;
                    head = head.next;
                    temp.next = curr;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if(curr == null) {
                prev.next = head;
                temp = head;
                head = head.next;
                temp.next = null;
            }
        }
        return dummy.next;
    }
}