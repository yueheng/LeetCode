/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        if(k > len) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head, next = curr.next;
        for(int i = 0; i < len/k; i++) {
            int t = k;
            ListNode nextPrev = null;
            while(t > 1) {
                ListNode nextcurr = next;
                prev.next = next;
                next = next.next;
                prev.next.next = curr;
                if(t == k) nextPrev = curr;
                if(t == 2) {
                    prev = nextPrev;
                    curr = next;
                    prev.next = curr;
                    if(next != null) next = next.next;
                }
                else curr = nextcurr;
                t--;
            }
        }
        return dummy.next;
    }
}


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = head;
        while(head != null) {
            ListNode temp = head;
            int count = 0;
            while(temp != null && count < k) {
                count++;
                temp = temp.next;
            }
            if(count < k) break;
            next = temp;
            ListNode tempPrev = prev;
            temp = head;
            ListNode tempNext = head.next;
            while(temp != next) {
                temp.next = tempPrev;
                tempPrev = temp;
                temp = tempNext;
                if(tempNext != null)tempNext = tempNext.next;
            }
            head.next = next;
            prev.next = tempPrev;
            prev = head;
            head = next;
            
        }
        return dummy.next;
    }
}