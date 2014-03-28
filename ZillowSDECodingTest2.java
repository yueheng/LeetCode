//---------------------------------Question1----------------------------------------------------
public class Question1 {
	public static void main(String[] args) {
		long i = stringToLong("123");
		if (i == 123) { // success
			System.out.println("Success");
		}			
		else {  // failure
			System.out.println("Invalid string or other error");
		}			
	}
	
	public static long stringToLong(String s){
		/* code goes here to convert a string to a long */
		if(s == null || s.length() == 0) return 0;  //if string s is null or empty, return 0;
		int identify = 1;     //identify to identify whether the number is positive or negative
		long toReturn = 0;
		int len = s.length();
		int i = 0;
		
		while(i < len && s.charAt(i) == ' ') i++;  //skip whitespaces
		if(i < len && s.charAt(i) == '-') {                   //find the identify, 
			identify = -1;                         //which represent the number is positive or negative
			i++;
		}
		else if(i < len && s.charAt(i) == '+') i++;
		
		while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {  
			if((toReturn == Long.MAX_VALUE / 10 && s.charAt(i) > Long.MAX_VALUE % 10) 
				|| toReturn > Long.MAX_VALUE / 10) {  //check if number is too big or too small
				return identify > 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
			}
			toReturn = toReturn * 10 + s.charAt(i) - '0';
			i++;
		}
		return identify > 0? toReturn : -toReturn;
	}	
}






//--------------------------------------Question2---------------------------------------

import java.util.*;
class TriTreeNode {  
	TriTreeNode left;
	TriTreeNode middle;
	TriTreeNode right;
	int val;
	public TriTreeNode(int val) {
		this.val = val;
	}
}


/*
manipulate tri-nary tree
*/
public class Question2 {	
	public static void main(String[] args) {
		int[] arr = {5, 4, 9, 5, 7, 2, 2};
		TriTreeNode root = generateTree(arr);    //generate the original tree
		doPrint(root);                    //print the tree
        root = doDelete(root, 4);           //delete and print
        root = doDelete(root, 5);
        root = doDelete(root, 9);
        root = doDelete(root, 2);
        root = doDelete(root, 5);
        root = doDelete(root, 7);
        root = doDelete(root, 2);
	}
	
	//generate the whole tree
	public static TriTreeNode generateTree(int[] num) {
		if(num == null || num.length == 0) return null;
		TriTreeNode node = insert(null, num[0]);
		for(int i = 1; i < num.length; i++) {
			insert(node, num[i]);
		}
		return node;
	}
	
	public static TriTreeNode doDelete(TriTreeNode root, int val) {
		System.out.println("After Deleting: " + val);
		root = delete(root, val);
		doPrint(root);
		return root;
	}
	
	//insert a number
	public static TriTreeNode insert (TriTreeNode node, int val) {  
		if (node == null) 	node = new TriTreeNode(val);
		else if (val < node.val) node.left = insert(node.left, val);
		else if (val > node.val) node.right = insert(node.right, val);
		else node.middle = insert(node.middle, val) ;
		return node;
	}
	
	//delete a number
	public static TriTreeNode delete(TriTreeNode node, int val) {
		if(node == null) return null;
		//go to left branch to find target node
		if(val < node.val) node.left = delete(node.left, val);  
		//go to right branck to find target node
		else if(val > node.val) node.right = delete(node.right, val);
		
		else {  //find target node 
			//use middle to replace node to be deleted, if middle is not null 
			if(node.middle != null) {
    		    TriTreeNode middle = node.middle;
                middle.left = node.left;   //use middle to replace
                middle.right = node.right;
				node.left = null;    //delete node
				node.right = null;
                return middle;             
			}
			//use node.left to replace the node to be deleted, if middle is null and right is null
			if(node.right == null) {
				TriTreeNode left = node.left;
				node.left = null;
				return left;
			}
			//use node.right to replace the node to be deleted, if middle is null and left is null
			if(node.left == null) {
				TriTreeNode right = node.right;
				node.right = null;
				return right;
			}
			//if middle is null, but both left and right are not null, use the leftmost child of right child
			//to replace node to be deleted
			TriTreeNode temp = node.right;
			TriTreeNode tempParent = node;
			while(temp.left != null) {				
				tempParent = temp;
				temp = temp.left;
			}			
			temp.left = node.left;
			if(temp != node.right) temp.right = node.right;
			temp.middle = node.middle;
            tempParent.left = null;
			node.left = null;   //delete node
			node.right = null;
			node.middle = null;
			return temp;			
		}
		return node;
	}
	
	//bfs to traverse the whole tree and print each level
	public static void doPrint(TriTreeNode node) {
		if(node == null) return;
		Queue<TriTreeNode> queue = new LinkedList<TriTreeNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {  //print each level
				TriTreeNode temp = queue.remove();
                if(temp == null) continue;
				System.out.print(temp.val + " ");
				if(temp.left != null) queue.add(temp.left);
				if(temp.middle != null) queue.add(temp.middle);
				if(temp.right != null) queue.add(temp.right);
			}
			System.out.println();
		}
		System.out.println();
	}
}

