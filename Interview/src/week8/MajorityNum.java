package week8;

import java.util.Arrays;

public class MajorityNum {
    public int majorityElement(int[] num) {
    	Arrays.sort(num);
    	int i = num.length / 2;
    	return num[i];

    }
    public static void main (String[] args) {
    	int[] A = {2,2,1,1,2,2,2,3};
    	MajorityNum result = new MajorityNum();
    	System.out.println(result.majorityElement(A));
    }
}
