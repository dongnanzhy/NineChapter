package week8;

import java.util.HashMap;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * 
 */
public class TwoSum {
	// This cannot solve the question, since we have to return the index
    public int[] twoSum_Pointer(int[] numbers, int target) {
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
    
    // The right answer
    public int[] twoSum(int[] numbers, int target) {
    	if (numbers == null || numbers.length == 0) {
    		return null;
    	}
    	int[] rst = new int[2];
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i++) {
    		map.put(numbers[i], i + 1);
    	}
    	for (int i = 0; i < numbers.length; i++) {
    		if (map.containsKey(target - numbers[i])) {
    			int index1 = i + 1;
    			int index2 = map.get(target - numbers[i]);
    			if (index1 == index2) {
    				continue;
    			}
    			rst[0] = index1;
    			rst[1] = index2;
    			return rst;
    		}
    	}
    	return rst;
    }
}
