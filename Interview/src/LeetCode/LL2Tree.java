package LeetCode;

import week3.BuildTree.TreeNode;
import week4.BuildList.ListNode;

/*
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class LL2Tree {
	private ListNode curr;
	
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
        	return null;
        }
        int size = getSize (head);
        curr = head;
        return buildBST (size);
    }
    
    public int getSize (ListNode head) {
    	int size = 0;
    	while (head != null) {
    		head = head.next;
    		size ++;
    	}
    	return size;
    }
    
    /*
     * Using recursion to build the left subtree and right subtree.
     */
    public TreeNode buildBST (int size) {
    	if (size <= 0) {
    		return null;
    	}
    	TreeNode left = buildBST(size/2);
    	TreeNode root = new TreeNode(curr.val);
    	curr = curr.next;
    	TreeNode right = buildBST(size - 1 - size/2);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}
