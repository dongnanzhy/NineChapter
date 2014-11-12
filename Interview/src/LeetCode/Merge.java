package LeetCode;

public class Merge {
	/*
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
	 */
    public void merge(int A[], int m, int B[], int n) {
    	int Alength = m;
    	int Blength = n;
        if (A == null) {
        	return;
        }
        if (B == null) {
        	return;
        }
    	int[] temp = new int[Alength + Blength];
        int i = 0, j = 0, k = 0;
        while (i < Alength && j < Blength) {
        	if (A[i] <= B[j]) {
        		temp[k] = A[i];
        		i++; k++;
        	}
        	if (A[i] > B[j]) {
        		temp[k] = B[j];
        		j++; k++;
        	}
        }
        while (i < Alength) {
    		temp[k] = A[i];
    		i++; k++;
        }
        while (j < Blength) {
    		temp[k] = B[j];
    		j++; k++;
        }
       	for (int index = 0; index < Alength + Blength; index++) {
			A[index] = temp[index];
		}
    }
}
