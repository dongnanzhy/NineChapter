package week3;

import java.util.*;

public class BuildTree {
	public static class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode (int x) { val = x; }
	}
	
	public TreeNode buildTree (int[] num) {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<TreeNode> parent = new LinkedList<TreeNode>();
		if (num.length == 0 || num[0] == '#') {
			return null;
		}
		for (int i = 0; i < num.length; i++) {
			q.offer(num[i]);
		}

		//		int val = Integer.parseInt(num[0]);
		TreeNode root = new TreeNode(q.poll());
		parent.offer(root);
		while (!q.isEmpty()) {
			int size = parent.size();
			Queue<TreeNode> current = new LinkedList<TreeNode>();
			for (int i = 0; i < size; i++) {             //travel by layer
				TreeNode node = parent.poll();
				if (q.isEmpty()) {
					break;
				}
				int val = q.poll();
				if (val != '#') {
					node.left = new TreeNode(val);
					current.offer(node.left);
				} else {
					node.left = null;
				}
				if (q.isEmpty()) {
					break;
				}
				val = q.poll();
				if (val != '#') {
					node.right = new TreeNode(val);
					current.offer(node.right);
				} else {
					node.right = null;
				}
			}
			parent = current;
		}
		return root;
	}
	
}
