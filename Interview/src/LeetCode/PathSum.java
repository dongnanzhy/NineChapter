package LeetCode;

import week3.BuildTree.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) {
    		return false;
    	}
        if (root.left == null && root.right == null) {
        	if (root.val == sum) return true;
        	else return false;
        } else if (root.left != null && root.right == null) {
        	return hasPathSum(root.left, sum - root.val);
        } else if (root.left == null && root.right != null) {
        	return hasPathSum(root.right, sum - root.val);
        } else {
        	return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
        }
    }
}
