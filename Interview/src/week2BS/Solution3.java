/*
 * Search in Rotated Sorted Array 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	You are given a target value to search. If found in the array return its index, otherwise return -1.

	You may assume no duplicate exists in the array.
 */

package week2BS;

public class Solution3 {
    public int search(int[] A, int target) {
        if (A.length == 0) {
        	return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
    		if (A[mid] == target) {
    			return mid;
    		}
        	if (A[mid] > A[start]){                               // (A[mid] > A[start] && A[mid] > A[end]) is wrong
        		if (A[mid] > target && A[start] <= target) {      // Here should use <=, or we can not detect start
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else {
        		if (A[mid] < target && A[end] >= target) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }
        if (A[start] == target) {
        	return start;
        } else if (A[end] == target) {
        	return end;
        } else {
        	return -1;
        }
    }
    
	public static void main(String args[]) {
		int[] num = {4,5,6,7,0,1,2};
		int target = 2;
		Solution3 s = new Solution3();
		System.out.println(s.search(num, target));
	}
}
