package week8;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> rst = new  ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
        	return rst;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	for (int j = i + 1; j < num.length - 2; j++) {
            	if (j != i + 1 && num[j] == num[j - 1]) {
            		continue;
            	}
            	int left = j + 1;
            	int right = num.length - 1;
            	while (left < right) {
            		int sum = num[i] + num[j] + num[left] + num[right];
            		if (sum == target) {
            			ArrayList<Integer> tmp = new ArrayList<Integer>();
            			tmp.add(num[i]);
            			tmp.add(num[j]);
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
            		} else if (sum < target) {
            			left++;
            		} else {
            			right--;
            		}
            	}
        	}
        }
        return rst;
    }
    
    public static void main (String[] args) {
    	int[] A = {1, 0, -1, 0, -2, 2};
    	FourSum result = new FourSum();
    	System.out.println(result.fourSum(A, 0));
    }
}
