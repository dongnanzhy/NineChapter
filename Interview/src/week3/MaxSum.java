package week3;

public class MaxSum {
	int max = -256;
	public int maxPathSum(BuildTree.TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left != null && root.right != null) {
    		int result = root.val + max(root.left) + max(root.right);
    		return max > result ? max : result;
        }else if (root.left != null && root.right == null) {
    		int result = root.val + max(root.left);
    		return max > result ? max : result;
        }else if (root.left == null && root.right != null) {
    		int result = root.val + max(root.right);
    		return max > result ? max : result;
        }else if (root.left == null && root.right == null) {
    		return root.val;
//    		return max > result ? max : result;
        }
        return 0;
	}
	
	// must return 0 if the value < 0. 
    public int max(BuildTree.TreeNode root) {
        if (root.left == null && root.right == null) {
        	max = max > root.val ? max : root.val;
        	return root.val > 0 ? root.val : 0;
        } else if (root.left != null && root.right != null) {
        	int left = max(root.left);
        	int right = max(root.right);
        	int result = root.val + (left > right ? left : right);
        	max = max > (root.val + left + right) ? max : (root.val + left + right);
        	return result > 0 ? result : 0;
        } else if (root.left != null && root.right == null) {
        	int left = max(root.left);
        	int result = root.val + left;
        	max = max > (root.val + left) ? max : (root.val + left);
        	return result > 0 ? result : 0;
        } else if (root.right != null && root.left == null) {
        	int right = max(root.right);
        	int result = root.val + right;
        	max = max > (root.val + right) ? max : (root.val + right);
        	return result > 0 ? result : 0;
        }
        return 0;
    }
    public static void main (String[] args) {
		int[] num = {-3,-4,0,'#','#',0,1,'#',7,'#',-3};
//		int[] num2 = {9,-2,'#',-3};
		BuildTree build = new BuildTree();
		BuildTree.TreeNode root = build.buildTree(num);
		
    	MaxSum maxsumpath = new MaxSum();
    	System.out.println(maxsumpath.maxPathSum(root));
    }
}
