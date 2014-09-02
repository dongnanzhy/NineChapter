/* Search in Rotated Sorted Array II -- duplicates
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?

	Would this affect the run-time complexity? How and why?

	Write a function to determine if a given target is in the array.
 */


package week2;

public class Solution4 {
	public boolean search(int[] A, int target) {
        if (A.length == 0) {
        	return false;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
        	if (A[mid] == target || A[start] == target || A[end] == target) {
        		return true;
        	} 
        	if (A[mid] == A[start] && A[mid] == A[end]) {
        		start++;
        		end--;
        		continue;                                            // can hold O(logN)
        	} else if (A[mid] >= A[start] && A[mid] != A[end]){
        		if (target < A[mid] && target > A[start]) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else if (A[mid] <= A[end] && A[mid] != A[start]){
        		if (target > A[mid] && target < A[end]) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	}
        }
        if (A[start] == target) {
        	return true;
        } else if (A[end] == target) {
        	return true;
        } else {
        	return false;
        }
    }
    
	public static void main(String args[]) {
		int[] num = {1,1,1,3,1,1};
		int target = 2;
		Solution4 s = new Solution4();
		System.out.println(s.search(num, target));
	}
}
