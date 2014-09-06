package bicmockinterview;

public class Sort {
	
	//Quick Sort, runtime O(nlgn), worst time O(n^2), 
	//in-place, good for locality of references, can use in Array Sort.
	public void QuickSortHelper(int[] ass, int left, int right) {
		int mid = (left + right)/2;
		int pivot = ass[mid];
		int i = left;
		int j = right;
		int temp;
		while (i <= j) {
			while (ass[i] < pivot) {
				i++;
			}
			while (ass[j] > pivot) {
				j--;
			}
			if (i <= j) {
                temp = ass[i];
                ass[i] = ass[j];
                ass[j] = temp;
//				ass[i] = ass[i] + ass[j];
//				ass[j] = ass[i] - ass[j];
//				ass[i] = ass[i] - ass[j];    
				/*swap without using temp;  cannot use in Java
                when i == j, ass[i] = 2ass[i]; then ass[j] = ass[i]; so in this way, 
                the result we get is 0*/
				i++;
				j--;
			}
		}
		if (left < j) {
			QuickSortHelper(ass, left, j);
		}
		if (right > i) {
			QuickSortHelper(ass, i, right);
		}
	}
	public void QuickSort (int[] ass) {
		int left = 0;
		int right = ass.length - 1;
		QuickSortHelper(ass, left, right);
	}
	
	//Merge Sort, runtime O(nlgn), but need O(n) memory, can use in Linked List
	public void Merge (int[] ass, int[] temp, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (ass[i] <= ass[j]) {
				temp[k] = ass[i];
				i++; k++;
			} else {
				temp[k] = ass[j];
				j++; k++;
			}
		}
		while (i <= mid) {
			temp[k++] = ass[i++];
		}
		while (j <= right) {
			temp[k++] = ass[j++];
		}
		for (int index = left; index <= right; index++) {
			ass[index] = temp[index];
		}
	}
	public void MergeSort (int[] ass, int[] temp, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right)/2;
		MergeSort(ass, temp, left, mid);
		MergeSort(ass, temp, mid + 1, right);
		Merge (ass, temp, left, mid, right);
	}
	
	public static void main (String[] args) {
		int[] ass = {1,2,3,4,5,6,7,8,9};
		Sort sort = new Sort();
		sort.QuickSort(ass);
		for (int i = 0; i < ass.length; i++) {
			System.out.print(ass[i]);
		}
		System.out.println();
		int[] ass2 = {3,7,7,2,9,9,5,5,4,1,8,6};
		int[] temp = new int[ass2.length];
		sort.MergeSort(ass2, temp, 0, ass2.length - 1);
		for (int i = 0; i < ass2.length; i++) {
			System.out.print(ass2[i]);
		}
	}
}
