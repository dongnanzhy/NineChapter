package week6;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (S == null || S.length == 0) {
        	return result;
        }
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort(S);
    	helper(result, list, S, 0);
    	return result;
    }
    
    private void helper( ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] S, int pos) {
    	result.add(new ArrayList<Integer>(list));
    	for (int i = pos; i < S.length; i++) {
    		list.add(S[i]);
    		helper(result, list, S, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}
