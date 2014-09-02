package week3;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(BuildTree.TreeNode root) {
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<BuildTree.TreeNode> que = new LinkedList<BuildTree.TreeNode>();
        if (root == null) {
        	return result;
        }
        que.offer(root);
        BuildTree.TreeNode node = root;
        while (!que.isEmpty()) {
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	int size = que.size();
        	for (int i = 0; i < size; i++) {
        		node = que.poll();
        		list.add(node.val);
        		if (node.left != null) {
        			que.offer(node.left);
        		}
        		if (node.right != null) {
        			que.offer(node.right);
        		}
        	}
        	result.add(list);
        }
    return result;
    }
    public static void main (String[] args) {
		int[] num = {1,2,3,4,5,6,7,8,9};
		BuildTree build = new BuildTree();
		BuildTree.TreeNode root = build.buildTree(num);
		
    	LevelOrderTraversal travel = new LevelOrderTraversal();
    	System.out.println(travel.levelOrder(root));
    }
}
