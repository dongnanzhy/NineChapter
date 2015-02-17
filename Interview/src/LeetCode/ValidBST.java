package LeetCode;

import week3.BuildTree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * @author dongnanzhy
 *
 */
public class ValidBST {
	
	// Method 1
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean checkBST(TreeNode node, int min, int max) {
    	if (node == null) {
    		return true;
    	}
    	if (node.val <= min || node.val > max) {
    		return false;
    	}
    	if (!checkBST(node.left, min, node.val) ||
    			!checkBST(node.right, node.val, max)) {
    		return false;
    	}
    	return true;
    }
    
    // Method 2
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST2(root.right)) {
            return false;
        }
        return true;
    }
}
