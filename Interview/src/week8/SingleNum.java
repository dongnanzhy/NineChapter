package week8;

public class SingleNum {
	
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 */
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
        	return -1;
        }
        int rst = 0;
        for (int i = 0; i<A.length; i++) {
        	rst = rst ^ A[i];
        }
        return rst;
    }
    
    /*
     * Given an array of integers, every element appears three times except for one. Find that single one.
     */
    public int singleNumber2(int[] A) {
        if (A == null || A.length == 0) {
        	return -1;
        }
        int rst = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
        	for (int j = 0; j < A.length; j++) {
        		bits[i] = bits[i] + (A[j]>>i & 1);
        		bits[i] = bits[i] % 3;
        	}
        	rst = rst | bits[i]<<i;
        }
        return rst;
    }
    
    public static void main (String[] args) {
    	int[] A = {1,2,1,1,2,2,3,3};
    	SingleNum result = new SingleNum();
    	System.out.println(result.singleNumber2(A));
    }
}
