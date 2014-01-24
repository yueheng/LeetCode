/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        Comparator<ListNode> com = new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if(l1.val < l2.val) return -1;
                else if(l1.val > l2.val) return 1;
                else return 0;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), com);
        for(ListNode node: lists) {
            if(node != null) queue.add(node);
        }
        ListNode head = queue.poll();
        ListNode curr = head;
        if(curr != null && curr.next != null) queue.add(curr.next);
        while(!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if(curr.next != null) queue.add(curr.next);
        }
        return head;
    }
}