package week8;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new  ArrayList<ArrayList<Integer>>();
        
    	if (num == null || num.length == 0) {
        	return rst;
        }
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	int left = i + 1;
        	int right = num.length - 1;
        	while (left < right) {
            	int sum = num[left] + num[right] + num[i];
            	if (sum == 0) {
            		ArrayList<Integer> tmp = new ArrayList<Integer>();
            		tmp.add(num[i]);
            		tmp.add(num[left]);
            		tmp.add(num[right]);
            		rst.add(tmp);
            		left++;
            		right--;
            		while (left < right && num[left] == num[left - 1]) {
            			left++;
            		}
            		while (left < right && num[right] == num[right + 1]) {
            			right--;
            		}
            	} else if (sum < 0) {
            		left++;
            	} else {
            		right--;
            	}          	
        	}
        }
        return rst;
    }
    
    public static void main (String[] args) {
    	int[] A = {-1, 0, 1, 2, -1, -4};
    	ThreeSum result = new ThreeSum();
    	System.out.println(result.threeSum(A));
    }
}
