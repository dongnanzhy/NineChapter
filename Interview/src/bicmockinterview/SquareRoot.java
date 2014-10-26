package bicmockinterview;

public class SquareRoot {
	public double sqRoot (double n, double eps) {
		if (n < 0) {
			return -1;
		}
		if (0 == n) {
			return 0;
		}
		double left, right, mid;
		if (n < 1) {
			left = n;
			right = 1;
		} else {
			left = 1;
			right = n;
		}
		mid = left + (right - left)/2;
		while (right - left > eps) {
			mid = left + (right - left)/2;
			if (mid * mid == n) {
				return mid;
			}else if (mid * mid < n) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return mid;
	}
	
	public static void main (String[] args) {
		SquareRoot s = new SquareRoot();
		System.out.println(s.sqRoot(16, 0.00001));
	}
}
