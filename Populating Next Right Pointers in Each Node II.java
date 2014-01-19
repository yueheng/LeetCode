/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeLinkNode currNode = curr.remove();
            TreeLinkNode nextNode = null;
            if(currNode.left != null) next.add(currNode.left);
            if(currNode.right != null) next.add(currNode.right);
            while(!curr.isEmpty()) {
                nextNode = curr.remove();
                currNode.next = nextNode;
                currNode = nextNode;
                if(currNode.left != null) next.add(currNode.left);
                if(currNode.right != null) next.add(currNode.right);
            }
            Queue<TreeLinkNode> temp = curr;
            curr = next;
            next = temp;
        }
    }
}
}