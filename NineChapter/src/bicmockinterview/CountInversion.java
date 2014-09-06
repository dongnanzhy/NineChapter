package bicmockinterview;

public class CountInversion {
	public int merge (int[] ass, int[] temp, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		int inversion = 0;
		while (i <= mid && j <= right) {
			if (ass[i] <= ass[j]) {
				temp[k++] = ass[i++];
			} else {
				temp[k++] = ass[j++];
				inversion += mid - i + 1;
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
		return inversion;
	}
	public int Count (int[] ass, int[] temp, int left, int right) {
		if (left >= right) {
			return 0;
		}
		int mid = (left + right) / 2;
		int count_inversion = 0;
		count_inversion = Count(ass, temp, left, mid);
		count_inversion += Count(ass, temp, mid + 1, right);
		count_inversion += merge(ass, temp, left, mid, right);
		return count_inversion;
	}
	
	public static void main (String[] args) {
		int[] ass = {1,20,6,4,5};
		CountInversion c = new CountInversion();
		int[] temp = new int[ass.length];
		System.out.println(c.Count(ass, temp, 0, ass.length - 1));
	}
}
