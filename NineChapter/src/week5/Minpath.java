package week5;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author Yan
 *
 */
public class Minpath {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
        	for (int j = n - 1; j >= 0; j--) {
        		if (i == m -1 && j == n - 1) {
        			continue;
        		}
        		if (i == m - 1) {
        			sum [i][j] = sum [i][j + 1] + grid[i][j];
        		} else if (j == n - 1) {
        			sum [i][j] = sum [i + 1][j] + grid[i][j];
        		} else {
        			sum [i][j] = Math.min(sum[i + 1][j], sum[i][j + 1]) + grid[i][j];
        		}
        	}
        }
        return sum[0][0];
    }
    public static void main (String[] args) {
    	int[][] grid = 
    		{
    			{1,5,3},
    			{2,3,4},
    			{1,2,3}
    		};
    	Minpath min = new Minpath();
    	System.out.println(min.minPathSum(grid));
    }
}
