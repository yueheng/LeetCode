/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head;
        while(temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            RandomListNode curr = map.get(temp);
            if(temp.next != null) curr.next = map.get(temp.next);
            if(temp.random != null) curr.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}