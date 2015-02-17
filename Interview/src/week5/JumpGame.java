package week5;


public class JumpGame {
	
	 /**
	  * Jump Game 
	  * @param args
	  */
	 public boolean canJump(int[] A) {
	        if (A == null || A.length == 0) {
	        	return false;
	        }
	        int size = A.length;
	        boolean[] Jump = new boolean[size];
	        for (int i = 1; i < size; i++) {
	        	Jump[i] = false;
	        }
	        Jump[0] = true;
	        for (int i = 0; i < size; i++) {
	        	if (!Jump[i]) {
	        		continue;
	        	}
	        	int j = 1;
	        	while(j<=A[i]) {
	        		if (i+j < size) {
	            		Jump[i+j]=true;
	        		}
	        		j++;
	        	}
	        }
	        return Jump[size-1];
	    }
	 
	 /**
	  * Jump Game 2
	  * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	  * Each element in the array represents your maximum jump length at that position.
	  * Your goal is to reach the last index in the minimum number of jumps.
	  * @param args
	  */
	    public int jump(int[] A) {
	        if (A == null || A.length == 0) {
	        	return 0;
	        }
	        int lastReach = 0;
	        int reach = 0;
	        int step = 0;
	        for (int i = 0; i < A.length && i <= reach; i++) {
	        	if (i > lastReach) {
	        		step++;
	        		lastReach = reach;
	        	}
	        	reach = Math.max(reach, i + A[i]);
	        }
	       	if (reach < A.length - 1) {
	        	return 0;
	        }
	        return step;
	    }
	 
	    public static void main (String[] args) {
	    	
	    	JumpGame j = new JumpGame();
	    	int[] A = {3,2,1,0,4};
	    	System.out.println(j.canJump(A));
	    }
}
