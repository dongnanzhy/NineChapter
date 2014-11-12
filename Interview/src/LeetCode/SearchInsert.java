package LeetCode;

public class SearchInsert {
	/*
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * You may assume no duplicates in the array.
	 */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
        	return 0;
        }
    	int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
        	if (A[mid] == target) {
        		return mid;
        	} else if (A[mid] < target) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        if (A[start] >= target) {
        	return start;
        } else if (target > A[start] && target <= A[end]) {
        	return end;
        } else {
        	return end + 1;
        }
    }
    
    public static void main (String[] args) {
    	int[] A = {1,3,5,7};
    	int target = 5;
    	SearchInsert rst = new SearchInsert();
    	System.out.println(rst.searchInsert(A, target));
    }
}
