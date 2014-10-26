package week3;
import java.util.*;

public class Zigzag {
    public List<List<Integer>> zigzagLevelOrder(BuildTree.TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<BuildTree.TreeNode> que = new LinkedList<BuildTree.TreeNode>();
        Stack<BuildTree.TreeNode> stack = new Stack<BuildTree.TreeNode>();
        boolean direction = true;
        if (root == null) {
        	return result;
        }
        BuildTree.TreeNode node = null;
        que.offer(root);
        while (!que.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
            	node = que.poll();
            	if (node.left != null) {
            		que.offer(node.left);
            	}
            	if (node.right != null) {
            		que.offer(node.right);
            	}
            	if (direction) {
            		list.add(node.val);
            	} else {
            		stack.push(node);
            	}
            }
            if (!direction) {
            	int size_stack = stack.size();
            	for (int i = 0; i < size_stack; i++) {
            		node = stack.pop();
            		list.add(node.val);
            	}
            }
            direction = !direction;
            result.add(list);
        }
        return result;
    }
    
    public static void main (String[] args) {
		int[] num = {3,9,20,'#','#',15,7};
		BuildTree build = new BuildTree();
		BuildTree.TreeNode root = build.buildTree(num);
		
    	Zigzag zigzag = new Zigzag();
    	System.out.println(zigzag.zigzagLevelOrder(root));
    }
}
