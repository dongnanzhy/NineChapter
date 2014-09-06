package bicmockinterview;

public class FindKth {
	public void exchange (int[] ass, int i, int j) {
		int temp;
		temp = ass[i];
		ass[i] = ass[j];
		ass[j] = temp;
	}
	public int partition (int[] ass, int left, int right) {
		int pivot = ass[left];
		int i = left+1;
		int j = right;
		while (i <= j) {
			while (i <= j && ass[i] < pivot) {
				i++;
			}
			while (i <= j && ass[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange (ass, i, j);
				i++; j--;
			}
		}
		if (ass[j] > pivot) {             // to identify whether j or j-1 is pivot
			exchange (ass, left, j-1);
			return j-1;
		} else {
			exchange (ass, left, j);
			return j;
		}
	}
	public int findk (int[] ass, int left, int right,int k) {
		int index = partition(ass, left, right);
//		System.out.println(index);
		if (index == k-1) {
			return ass[index];
		} else if (index > k-1) {
            return findk(ass, left, index-1, k);
		} else {
	        return findk(ass, index+1, right, k);	
		} 

	} 
	
	public static void main (String[] args) {
		int[] ass = {3,6,2,9,1,4,5,8,7,10};
		int k = 8;
		FindKth find = new FindKth();
		System.out.println(find.findk(ass, 0, ass.length - 1, k));
	}
}
