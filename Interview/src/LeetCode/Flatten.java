package LeetCode;

import week3.BuildTree.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * @author dongnanzhy
 *
 */
public class Flatten {
	private TreeNode prevNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
        	return;
        }
        if (prevNode != null) {
        	prevNode.left = null;
        	prevNode.right = root;
        }
        prevNode = root;
        //  To protect root.right
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
