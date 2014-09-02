package week3;
import java.util.*;

public class Traversal {
/*	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {x = val;}
	}
*/
	
	public void Preorder_traversal (BuildTree.TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		Preorder_traversal(root.left, result);
		Preorder_traversal(root.right, result);
		return;
	}
    public List<Integer> preorderTraversal2(BuildTree.TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        }
        Stack<BuildTree.TreeNode> stack = new Stack<BuildTree.TreeNode>();
        BuildTree.TreeNode node = root;
        stack.push(root);
        while (!stack.isEmpty()) {

            node = stack.pop();

        	list.add(node.val);
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
//        		node = node.left;
        	}
        }
        return list;
    }
    public List<Integer> inorderTraversal(BuildTree.TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        }
        Stack<BuildTree.TreeNode> stack = new Stack<BuildTree.TreeNode>();
        BuildTree.TreeNode node = root;
        stack.push(root);
        boolean check = true;
        while (!stack.isEmpty() || node.right != null) {
        	if(check && node.left != null) {
        		stack.push(node.left);
        		node = node.left;
        	} else {
        		if (node.right != null) {
               		if (check) {
               			node = stack.pop();
               			list.add(node.val);
               		}
        			stack.push(node.right);
        			node = node.right;
        			check = true;
        		} else {
                		node = stack.pop();
                		list.add(node.val);
                		check = false;
        		}
        	}
        }
        return list;
    }
	
    public ArrayList<Integer> postorderTraversal(BuildTree.TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<BuildTree.TreeNode> stack = new Stack<BuildTree.TreeNode>();
        BuildTree.TreeNode prev = null; // previously traversed node
        BuildTree.TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
        	curr = stack.peek();
        	if (prev == null || prev.left == curr || prev.right == curr) {
        		if (curr.left != null) {
        			stack.push(curr.left);
        		} else if (curr.right != null) {
        			stack.push(curr.right);
        		}
        	} else if (prev == curr.left) {
        		if (curr.right != null) {
        			stack.push(curr.right);
        		}
        	} else {
        		result.add(curr.val);
        		stack.pop();
        	}
        	prev = curr;
        }
      return result;  
    }
 /*   public List<Integer> postorderTraversal(BuildTree.TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        }
        Stack<BuildTree.TreeNode> stack = new Stack<BuildTree.TreeNode>();
//        Queue<BuildTree.TreeNode> que = new LinkedList<BuildTree.TreeNode>();
//        Queue<BuildTree.TreeNode> que2 = new LinkedList<BuildTree.TreeNode>();
        BuildTree.TreeNode node = root;
        stack.push(root);
        boolean check_left = true;
        BuildTree.TreeNode pre = null;
//        boolean check_right = true;
        while (!stack.isEmpty()|| node.right != null) {
        	if(check_left && node.left != null) {
        		stack.push(node.left);
        		node = node.left;
        	} else if(pre != node && node.right != null) {
//        		stack.push(node);
        		pre = node;
        		stack.push(node.right);
        		node = node.right;
 //       		check_right = false;
        		check_left = true;
        	} else {
//        		node = stack.peek();
        		if (node.left == null && node.right == null) {
            		node = stack.pop();
        			list.add(node.val);
            		if (!stack.isEmpty()) {
                		node = stack.peek();
            		} else {
            			break;
            		}
            		check_left = false;
        		} else if (pre == node || node.right == null) {
            		node = stack.pop();
        			list.add(node.val);
//        			check_right = true;
            		if (!stack.isEmpty()) {
                		node = stack.peek();
            		} else {
            			break;
            		}
            		check_left = false;
        		} 
        	} 
        }
        return list;
    }
    */
	public static void main (String[] args) {
		int[] num = {1,2,3,4,5,6};
		BuildTree build = new BuildTree();
		BuildTree.TreeNode root = build.buildTree(num);
		
		Traversal travel = new Traversal();
		ArrayList<Integer> result = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		List<Integer> result_inorder = new ArrayList<Integer>();		
		List<Integer> result_postorder = new ArrayList<Integer>();
		
		travel.Preorder_traversal (root, result);
		result2 = travel.preorderTraversal2 (root);
		result_inorder = travel.inorderTraversal(root);
		result_postorder = travel.postorderTraversal(root);
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result_inorder);
		System.out.println(result_postorder);
	}
}
    
    

