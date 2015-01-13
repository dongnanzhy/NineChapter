package week8;

public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
        	return;
        }
        int pl = 0;
        int pr = A.length - 1;
        int i = 0;
        while (i <= pr) {
        	if (A[i] == 0) {
        		swap(A, i, pl);
        		i++;
        		pl++;
        	} else if (A[i] == 1) {
        		i++;
        	} else {
        		swap(A, i, pr);
        		pr--;
        	}
        }
    }
    private void swap(int[] A, int index1, int index2) {
    	int tmp = A[index1];
    	A[index1] = A[index2];
    	A[index2] = tmp;
    }
}
