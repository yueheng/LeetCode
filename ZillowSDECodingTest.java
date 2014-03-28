/*Question 1) Given a string, write a routine that converts the string to a long, without using the
built in functions that would do this. Describe what (if any) limitations the code has. 
Limitations: if string s is null or empty, code cannot tell part whether the number is 0 or string is null or empty.
*/

public class ZillowSDECodingTest1 {
	public static void main(String[] args) {
		long i = stringToLong("123");
		if (i == 123) { // success
			System.out.println("Success");
		}			
		else {  // failure
			System.out.println("Error");
		}			
	}
	
	public static long stringToLong(String s){
		/* code goes here to convert a string to a long */
		if(s == null || s.length() == 0) return 0;  //if string s is null or empty, return 0;
		long res = 0;
		int mask = 1;     //mask = 1 if number is positive, mask = -1 if number is negative
		int i = 0;
		int len = s.length();
		while(i < len && s.charAt(i) == ' ') i++;  //skip whitespaces
		if(s.charAt(i) == '-') {                   //check it's negative or positive
			mask = -1;
			i++;
		}
		else if(s.charAt(i) == '+') i++;
		//check character is valid number
		while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {  
			if((res == Long.MAX_VALUE / 10 && s.charAt(i) > Long.MAX_VALUE % 10) 
				|| res > Long.MAX_VALUE / 10) {  //check if number is too big or too small
				return mask > 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
			}
			res = res * 10 + s.charAt(i) - '0';
			i++;
		}
		return mask > 0? res : -res;
	}	
}





/*
Question 2) Implement insert and delete in a tri-nary tree. A tri-nary tree is much like a binary
tree but with three child nodes for each parent instead of two -- with the left node being values
less than the parent, the right node values greater than the parent, and the middle nodes values
equal to the parent.
*/
import java.util.*;
class TreeNode {   //data structure for tri-nary tree
    int val;
	TreeNode left;
	TreeNode right;
	TreeNode middle;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class ZillowSDECodingTest2 {	
	public static void main(String[] args) {
		int[] num = {5, 4, 5, 9, 2, 7, 2};
		TreeNode root = generate(num);    //generate the original tree
		doPrint(root);                    //print the tree
        root = delete(root, 4);           //delete and print
        doPrint(root);
        root = delete(root, 5);
        doPrint(root);
        root = delete(root, 9);
        doPrint(root);
        root = delete(root, 2);
        doPrint(root);
        root = delete(root, 5);
        doPrint(root);
        root = delete(root, 7);
        doPrint(root);
        root = delete(root, 2);
        doPrint(root);
	}
	
	//generate the whole tree
	public static TreeNode generate(int[] num) {
		if(num == null || num.length == 0) return null;
		TreeNode node = insert(null, num[0]);
		for(int i = 1; i < num.length; i++) {
			insert(node, num[i]);
		}
		return node;
	}
	
	//bfs to traverse the whole tree and print each level
	public static void doPrint(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {  //print each level
				TreeNode temp = queue.remove();
                if(temp == null) continue;
				System.out.print(temp.val + " ");
				if(temp.left != null) queue.add(temp.left);
				if(temp.middle != null) queue.add(temp.middle);
				if(temp.right != null) queue.add(temp.right);
			}
			System.out.println();
		}
        System.out.println("--------------");
	}

	//insert
	public static TreeNode insert (TreeNode node, int val) {  
		if (node == null) 	node = new TreeNode(val);
		else if (val < node.val) node.left = insert(node.left, val);
		else if (val == node.val) node.middle = insert(node.middle, val) ;
		else node.right = insert(node.right, val);
		return node;
	}
	
	//delete
	public static TreeNode delete(TreeNode node, int val) {
		if(node == null) return null;
		//go to left branch to find target node
		if(val < node.val) node.left = delete(node.left, val);  
		//go to right branck to find target node
		else if(val > node.val) node.right = delete(node.right, val);
		//target node if found
		else {
			//if middle is not null, use middle to replace node to be deleted
			if(node.middle != null) {
    		    TreeNode middle = node.middle;
                middle.left = node.left;
                middle.right = node.right;
                return middle;             
			}
			//if middle is null and right is null, use node.left to replace the node to be deleted 
			if(node.right == null) return node.left;
			//if middle is null and left is null, use node.right to replace the node to be deleted
			if(node.left == null) return node.right;
			//if middle is null, but both left and right are not null, use the leftmost child of right child
			//to replace node to be deleted
			TreeNode temp = node.right;
			TreeNode tempParent = node;
			while(temp.left != null) {				
				tempParent = temp;
				temp = temp.left;
			}			
			temp.left = node.left;
			if(temp != node.right) temp.right = node.right;
			temp.middle = node.middle;
            tempParent.left = null;
			return temp;			
		}
		return node;
	}
}

