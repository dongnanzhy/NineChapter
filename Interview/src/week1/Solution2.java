/*
 * Given a collection of numbers, return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

package week1;

import java.util.ArrayList;

public class Solution2 {
	int position = 0;
	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
	
	public ArrayList<ArrayList<Integer>> Permutation(int[] num){
        if (num == null || num.length == 0) {
            return rst; 
        }     										   // This is very important
        Permut(num);
        return rst;
	}
	
	public void Permut(int[] num){
		int N = num.length;
		
		if(position == N -1){
	        ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < N; i++){
				list.add(num[i]);
//				System.out.print(num[i]);
			}
			rst.add(list);
//			System.out.println();
		}
		for(int i = position; i<N; i++){        // i < N-1 is wrong
			exchange(num, position, i);
			position++;
			Permut(num);                  // position can also be a parameter of Permutation
			position--;
			exchange(num, position, i);
		}

	}
	
	public static void exchange(int[] num, int i, int j){
		int temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static void main(String args[]){
		int num[] = {1,2,3};
		Solution2 s = new Solution2();
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		solution = s.Permutation(num);
		System.out.println(solution);
	}
}
