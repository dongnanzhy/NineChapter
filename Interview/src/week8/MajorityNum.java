package week8;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * @author dongnanzhy
 *
 */
public class MajorityNum {
    public int majorityElement(int[] num) {
    	Arrays.sort(num);
    	int i = num.length / 2;
    	return num[i];

    }
    
    // This method is O(n)
    public int majorityElement2(int[] num) {
    	int candidate = num[0];
    	int count = 1;
    	for (int i = 1; i < num.length; i++) {
    		if (count == 0) {
    			candidate = num[i];
    			count = 1;
    		} else {
    			if (candidate == num[i]) {
    				count++;
    			} else {
    				count--;
    			}
    		}
    	}
    	return candidate;
    }
    
    public static void main (String[] args) {
    	int[] A = {2,2,1,1,2,2,2,3};
    	MajorityNum result = new MajorityNum();
    	System.out.println(result.majorityElement2(A));
    }
}
