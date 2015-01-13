package week6;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	private String[] drawList (ArrayList<Integer> cols) {
		String[] s = new String[cols.size()];
		for (int i = 0; i < cols.size(); i++) {
			s[i] = "";
			for (int j = 0; j < cols.size(); j++) {
				if (j == cols.get(i)) {
					s[i] = s[i] + "Q";
				} else {
					s[i] = s[i] + ".";
				}
			}
		}
		return s;
	}
	private boolean isValid (ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for (int i = 0; i < row; i++) {
			if (cols.get(i) == col) {
				return false;
			}
			if (i - row == cols.get(i) - col) {
				return false;
			}
			if (i - row == col - cols.get(i)) {
				return false;
			}
		}
		return true;
	}
	private void search (int n, List<String[]> result, ArrayList<Integer> cols) {
		if (cols.size() == n) {
			result.add(drawList(cols));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) {
				continue;
			}
			cols.add(col);
			search(n, result, cols);
			cols.remove(cols.size() - 1);
		}		
	}
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
        	return result;
        }
        ArrayList<Integer> cols = new ArrayList<Integer>();
        search(n, result, cols);
        return result;
    }
    
    public static void main(String[] args) {
    	NQueen ans =new NQueen();
    	int n = 5;
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	res = ans.solveNQueens(n);
    	if (res.size() == 0) {
    		System.out.println("No Solution");
    	} else {
        	for (int i = 0; i < res.size(); i++) {
        		System.out.println("Solution" + i);
        		for (int j = 0; j < n; j++) {
        			System.out.println(res.get(i)[j]);
        		}
        	}
    	}
  //  	System.out.println(res.get(0));
    }
}
