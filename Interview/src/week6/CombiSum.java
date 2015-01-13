package week6;

import java.util.ArrayList;
import java.util.Arrays;

public class CombiSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) {
        	return result;
        }
        ArrayList<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, result, solution, 0);
        return result;
    }
    private void helper(int[] candidates, int target, ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> solution, int index) {
    	if (target == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	//int prev = -1;
    	for (int i = index; i < candidates.length; i++) {
    		if (candidates[i] > target) {
    			break;
    		}
//    		if (prev != -1 && prev == candidates[i]) {
//    			continue;
//    		}
    		solution.add(candidates[i]);
    		helper(candidates, target - candidates[i], result, solution, i);
    		solution.remove(solution.size() - 1);
    		//prev = candidates[i];
    	}
    }
    
    public static void main(String[] args) {
    	int[] candidates = {2,3,6,7};
    	int target = 7;
    	CombiSum res = new CombiSum();
    	System.out.println(res.combinationSum(candidates, target));
    }
}
