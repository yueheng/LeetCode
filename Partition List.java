/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode small = null, big = null, smalltemp = null, bigtemp = null;
        while(head != null) {
            if(head.val < x) {
                if(small == null) small = head;
                else smalltemp.next = head;
                smalltemp = head;
            }
            else {
                if(big == null) big = head;
                else bigtemp.next = head;
                bigtemp = head;
            }
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
        if(small == null) return big;
        smalltemp.next = big;
        return small;
    }
}