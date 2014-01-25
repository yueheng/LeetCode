/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adder = 0;
        ListNode head = null;
        ListNode curr = null;
        while(l1 != null || l2 != null || adder > 0) {
            int temp = adder;
            if(l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            adder = temp/10;
            temp %= 10;
            if(head == null) {
                head = new ListNode(temp);
                curr = head;
            }
            else {
                curr.next = new ListNode(temp);
                curr = curr.next;
            }
        }
        return head;
    }
}