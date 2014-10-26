/* The k value (Median for example) of Two Sorted Arrays
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

package week2;

public class Solution5 {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
        	return (findtwoSortedArrays(A, B, len/2) + findtwoSortedArrays(A, B, len/2 + 1))/2.0;
        } else {
        	return findtwoSortedArrays(A, B, len/2 + 1);
        }
    }
    public static int findtwoSortedArrays(int A[], int B[], int k) {
        if(A.length == 0 && B.length == 0) {
        	return -1;
        }
        if (k > A.length + B.length || k <= 0) {
        	return -1;
        }
        int A_start = 0;
        int B_start = 0;
        if(A.length == 0) {									// if A is empty, find in B
        	return B[B_start + k - 1];
        }
        if(B.length == 0) {                                 // if B is empty, find in A
        	return A[A_start + k - 1];
        }

        while (k > 0) {
//            int mid = start + (end - start)/2;
            if (A_start >= A.length) {                    		// if A is found out, find the answer in B directly
            	return B[B_start + k - 1];
            }
            if (B_start >= B.length) {                   		// if B is found out, find the answer in A directly
            	return A[A_start + k - 1];
            }
            if (k == 1) {													// must in while loop; or ex {1} {1} is wrong
            	return A[A_start] < B[B_start] ? A[A_start] : B[B_start];	// k==1, so return the smaller one
            }
            if (A_start + k/2 -1 >= A.length) {					// if A is too short, cut the first part of B
            	B_start = B_start + k/2;
            	k = k - k/2;
            	continue;
            }
            if (B_start + k/2 -1 >= B.length) {			     	// if B is too short, cut the first part of A
            	A_start = A_start + k/2;
            	k = k - k/2;
            	continue;
            }
            if (A[A_start + k/2 - 1] < B[B_start + k/2 - 1]) {  // if mid of A < mid of B, cut the first part of A
            	A_start = A_start + k/2;
            	k = k - k/2;
            } else {                                            // if mid of A > mid of B, cut the first part of B
            	B_start = B_start + k/2;
            	k = k - k/2;
            }
        }
        return -1;
//        if (k == 1) {
//        	return A[A_start] < B[B_start] ? A[A_start] : B[B_start];	// k==1, so return the smaller one
 //       } else {
//       	return -1;
//        }   
    }
    
	public static void main(String args[]) {
		int[] A = {1};
		int[] B = {1};
//		int k = 12;
		Solution5 s = new Solution5();
		System.out.println(s.findMedianSortedArrays(A, B));
	}
}
