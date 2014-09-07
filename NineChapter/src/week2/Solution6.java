/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
  	[1,   3,  5,  7],
  	[10, 11, 16, 20],
  	[23, 30, 34, 50]

	Given target = 3, return true.
	Consider the following matrix:
 */

package week2;

public class Solution6 {
	//The first method
	// find from bottom left, if > target move right, if < target move up, with complexity O(n), it's very good
    public boolean searchMatrix_linear(int[][] matrix, int target) {         
        if (matrix.length == 0) {
        	return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start_row = rows - 1;
        int start_col = 0;
        while (start_row >=0 && start_col < cols) {
        	if (matrix[start_row] [start_col] == target) {
        		return true;
        	} else if (matrix[start_row] [start_col] < target) {
        		start_col++;
        	} else {
        		start_row--;
        	}
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
        	return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        return searchMatrix_quadrate(matrix, 0,rows, 0, cols, target);
    }
    
    // The second method
    // The quadrate way is to find the mid of diagonal, compare with target, 
    // remove upper left part, and recursion. With complexity O(n^log2(3)), so it is not as good as the first method
    public static boolean searchMatrix_quadrate(int[][] matrix, int start_row, int row_length, int start_col, int col_length, int target) {
        if (row_length == 2 && col_length == 2) {
        	if (matrix[start_row][start_col] == target || matrix[start_row][start_col + 1] == target || 
        			matrix[start_row + 1][start_col] == target || matrix[start_row + 1][start_col + 1] == target) {
        		return true;
        	} else {
        		return false;
        	}
        }
    	
    	if (row_length == 1 && col_length == 1) { 
        	if (matrix[start_row][start_col] == target) {
        		return true;
        	} else {
        		return false;
        	}
        } else if (row_length == 1) {
        	//return searchMatrix_quadrate(matrix, start_row, row_length, start_col + col_length/2, col_length - col_length/2, target);
        	for (int i = start_col; i < start_col + col_length; i++) {       //can use binary search
        		if (matrix[start_row][i] == target) {
        			return true;
        		}
        	}
        	return false;
        } else if (col_length == 1) {
        	//return searchMatrix_quadrate(matrix, start_row + row_length/2, row_length - row_length/2, start_col, col_length, target);
        	for (int i = start_row; i < start_row + row_length; i++) {        //can use binary search  
        		if (matrix[i][start_col] == target) {
        			return true;
        		}
        	}
        	return false;
        } else {
        	int length = row_length < col_length ? row_length : col_length;
        	while (length >= 1) {
        		if (matrix[start_row + length/2][start_col + length/2] == target) {
        			return true;
        		} else if (matrix[start_row + length/2][start_col + length/2] > target) {
        			length = (length/2 + 1)/2;
        		} else if (matrix[start_row + length/2][start_col + length/2] < target || length == 1) {
        			return searchMatrix_quadrate(matrix, start_row + length/2 + 1, row_length - length/2 - 1, start_col, length/2 + 1, target) ||
        					searchMatrix_quadrate(matrix, start_row, length/2 + 1, start_col + length/2 + 1, col_length - length/2 - 1, target) ||
        					searchMatrix_quadrate(matrix, start_row + length/2 + 1, row_length - length/2 - 1, start_col + length/2 + 1, col_length - length/2 - 1, target);
        		}
        	}
        	return false;
        }
    }
    
    // The third method, enhanced quadrate search. using recursion, find in diagonal, 
    //if target > row/col && target < row+1/col+1, throw the upper left and bottom right part
    // With the complexity of O(n), so it's as good as the first one
    public static boolean searchMatrix_binary(int[][] matrix, int start_row, int start_col, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
    	if (matrix[start_row][start_col] == target) {
    		return true;
    	} else if (matrix[start_row][start_col] > target){
    		return false;
    	} else if (matrix[start_row][start_col] < target) {
    		int row = start_row;
    		int col = start_col;
    		while (matrix[row][col] < target) {
    			if (row == rows - 1 && col == cols - 1) {
    				return false;
    			} else if (row == rows -1) {
        			return searchMatrix_binary(matrix, start_row, col + 1, target);      // can use binary search
    			} else if (col == cols - 1) {
    				return searchMatrix_binary(matrix, row + 1, start_col, target);
    			} else {
        			row++;
        			col++;
    			}
    		}
    		if (matrix[row][col] == target) {
    			return true;
    		} else if (matrix[row][col] > target) {
    			return searchMatrix_binary(matrix, row, start_col, target) 
    					|| searchMatrix_binary(matrix, start_row, col, target);
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
 
    
	public static void main(String args[]) {
		int[][] A = {
						{1,3,5,7},
						{10,11,16,20},
						{23,30,34,50}
				 	};
		int target = 8;
//		int k = 12;
		Solution6 s = new Solution6();
		System.out.println(s.searchMatrix_linear(A, target));
		System.out.println(s.searchMatrix(A, target));
	}
}
