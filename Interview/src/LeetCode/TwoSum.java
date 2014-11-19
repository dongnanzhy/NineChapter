package LeetCode;

import java.util.Collections;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * 
 * 
 * Unsolved!
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
        	return null;
        }
    	int start = 0;
        int end = numbers.length - 1;
        int[] rst = new int[2];
        while (start < end) {
        	if (numbers[start] + numbers[end] == target) {
        		rst[0] = start;
        		rst[1] = end;
        		break;
        	} else if (numbers[start] + numbers[end] < target) {
        		start++;
        	} else {
        		end--;
        	}
        }
        return rst;
    }
}
