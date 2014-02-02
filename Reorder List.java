/*
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        
        len = (len + 1) / 2;   //separate left and right
        temp = head;
        while(len > 1) {
            temp = temp.next;
            len--;
        }
        ListNode left = head, right = temp.next;
        temp.next = null;
        
        temp = right == null ? null : right.next;  //reverse right
        if(right != null)right.next = null;
        while(temp != null) {
            ListNode nexttemp = temp.next;
            temp.next = right;
            right = temp;
            temp = nexttemp;
        }
        
        while(left != null) {   //combine
            ListNode nextleft = left.next;
            ListNode nextright = right == null ? null : right.next;
            left.next = right;
            if(right != null)right.next = nextleft;
            left = nextleft;
            right = nextright;
        }
    }
}