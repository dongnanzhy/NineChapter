/* Search for a Range 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
	Your algorithm's runtime complexity must be in the order of O(log n).
	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4]
 */

package week2BS;

import java.util.Scanner;

public class Solution2 {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        if (A.length == 0) {
        	result[0] = -1;
        	result[1] = -1;
        	return result;
        }
        int start = 0;
        int end = A.length -1;
        int mid;
        //left boundary
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
        	if (A[mid] == target) {
        		end = mid;
        	} else if (A[mid] < target) {
        		start = mid;
        	} else if (A[mid] > target) {
        		end = mid;
        	}
        }
        if(A[start] == target){
        	result[0] = start;
        } else if(A[end] == target){
        	result[0] = end;
        } else {
        	result[0] = -1;
        }
        
        //right boundary
        start = 0;
        end = A.length -1;                          // Here needs redefine start and end
        while (start + 1 < end) {
        	mid = start + (end - start)/2;
        	if (A[mid] == target) {
        		start = mid;
        	} else if (A[mid] < target) {
        		start = mid;
        	} else if (A[mid] > target) {
        		end = mid;
        	}
        }
        if(A[end] == target){
        	result[1] = end;
        }else if(A[start] == target){
        	result[1] = start;
        }else {
        	result[1] = -1;
        }
        
        return result;
    }
    
	public static void main(String args[]) {
		int[] num = {1,2,2,2,4,4,5,6,6,7};
		Scanner input = new Scanner(System.in);
		int target = input.nextInt();
		Solution2 s = new Solution2();
		int[] result = new int[2];
		result = s.searchRange(num, target);
		System.out.println(result[0] + "  " + result[1]);
		input.close();
	}
}
