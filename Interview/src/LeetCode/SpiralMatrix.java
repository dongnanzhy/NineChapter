package LeetCode;

import java.util.ArrayList;

public class SpiralMatrix {
	/*
	 * Spiral Matrix
	 * Given a matrix of m x n elements (m rows, n columns), 
	 * return all elements of the matrix in spiral order.
	 */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
        	return rst;
        }
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (count * 2 < rows && count * 2 < cols) {
        	for (int i = count; i < cols - count; i++) {
        		rst.add(matrix[count][i]);
        	}
        	for (int i = count + 1; i < rows - count; i++) {
        		rst.add(matrix[i][cols - count - 1]);
        	}
        	// if only one row /col remains
        	if (count == rows - count - 1 || count == cols - count - 1) {
        		break;
        	}
        	for (int i = cols - count - 2; i >= count; i--) {
        		rst.add(matrix[rows - count - 1][i]);
        	}
        	for (int i = rows - count - 2; i > count; i--) {
        		rst.add(matrix[i][count]);
        	}
        	count++;
        }
        return rst;
    }
    
    /*
     * Spiral Matrix 2
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
        	return matrix;
        }
        int count = 0;
        int rows = n;
        int cols = n;
        int num = 1;
        while (count * 2 < rows) {
        	for (int i = count; i < cols - count; i++) {
        		matrix[count][i] = num++;
        	}
        	for (int i = count + 1; i < rows - count; i++) {
        		matrix[i][cols - count - 1] = num++;
        	}
        	for (int i = cols - count - 2; i >= count; i--) {
        		matrix[rows - count - 1][i] = num++;
        	}
        	for (int i = rows - count - 2; i > count; i--) {
        		matrix[i][count] = num++;
        	}
        	count++;
        }
        return matrix;
    }
    
    public static void main(String[] args) { 
    	SpiralMatrix result = new SpiralMatrix();
    	int[][] matrix = {{1,2,3,13},
    					  {4,5,6,16},
    					  {7,8,9,19}};
    	//System.out.println(result.spiralOrder(matrix));
    	int[][] matrix2 = result.generateMatrix(3);
    	for (int i = 0; i < matrix2.length; i++) {
    		for (int j = 0; j < matrix2.length; j++)
    			System.out.print(matrix2[i][j]);
    		System.out.println();
    	}
    }
}

