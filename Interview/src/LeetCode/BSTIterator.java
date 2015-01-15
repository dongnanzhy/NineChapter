package LeetCode;

import java.util.Stack;

import week3.BuildTree.TreeNode;

public class BSTIterator {
	private TreeNode curr = null;
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curr != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null) {
        	stack.push(curr);
        	curr = curr.left;
        }
        curr = stack.pop();
        TreeNode node = curr;
        curr = curr.right;
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
