package week5;


public class JumpGame {
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
	    public static void main (String[] args) {
	    	
	    	JumpGame j = new JumpGame();
	    	int[] A = {3,2,1,0,4};
	    	System.out.println(j.canJump(A));
	    }
}
