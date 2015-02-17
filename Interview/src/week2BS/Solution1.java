/* 
 *  Binary Search
     @param array source array
     @param target target to search
     @return the first occurrence position of target 
 */

package week2BS;
import java.util.Scanner;

public class Solution1 {
	public int binarySearch(int[] num, int target) {
		if (num.length == 0) {
			return -1;
		}                                       //num == null  and  num.length == 0 not the same
		int start = 0;
		int end = num.length - 1;
		int mid = 0;
		while (start + 1 < end) {                //start == end or start and end are neighbor,stop
			mid = start + (end - start)/2;
			if (num[mid] == target) {
				end = mid;                      //if no repeat character,return mid; if find the last occurrence target,start = mid
			} else if (num[mid] > target) {
				end = mid;
			} else if (num[mid] < target) {
				start = mid;
			}
		}
		if (num[start] == target) {
			return start;
		} else if (num[end] == target) {
			return end;
		} else {
			return -1;
		}
	}
	
	public static void main(String args[]) {
		int[] num = {1,2,2,2,4,4,5,6,6,7};
		Scanner input = new Scanner(System.in);
		int target = input.nextInt();
		Solution1 s = new Solution1();
		System.out.println(s.binarySearch(num, target));
		input.close();
	}

}
