package week5;


public class UniquePath {
	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 * How many possible unique paths are there?
	 * @author dongnanzhy
	 *
	 */
	public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
        	return 1;
        }
        int[][] sum = new int [m][n];
        for (int i = 0; i < m; i++) {
        	sum[i][n-1] = 1;
        }
        for (int j = 0; j < n; j++) {
        	sum[m-1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
        	for (int j = n - 2; j >= 0; j--) {
        		sum[i][j] = sum[i + 1][j] + sum[i][j + 1];
        	}
        }
        return sum[0][0];
    }
	
	/**
	 * Follow up for "Unique Paths":
	 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 * @param obstacleGrid
	 * @return
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0) {
        	return 0;
        }
        int[][] sum = new int [m][n];
        for (int i = m-1; i >= 0; i--) {
        	if (obstacleGrid[i][n-1] == 0) {
            	sum[i][n-1] = 1;
        	} else {
        		for (int temp =i; temp >= 0; temp--) {
            		sum[i][n-1] = 0;
        		}
        		break;
        	}
        }
        for (int j = n-1; j >= 0; j--) {
        	if (obstacleGrid[m-1][j] == 0) {
            	sum[m-1][j] = 1;
        	} else {
        		for (int temp =j; temp >= 0; temp--) {
        			sum[m-1][j] = 0;
        		}
        		break;
        	}
        }
        for (int i = m - 2; i >= 0; i--) {
        	for (int j = n - 2; j >= 0; j--) {
        		if (obstacleGrid[i][j] == 0) {
            		sum[i][j] = sum[i + 1][j] + sum[i][j + 1];
        		} else {
        			sum[i][j] = 0;
        		}
        	}
        }
        return sum[0][0];
    }
    
    public static void main (String[] args) {
    	int m = 3;
    	int n = 3;
    	int[][] obstacle = 
    		{
    			{0,0,0},
    			{0,0,1},
    			{0,0,0}
    		};
    	UniquePath path = new UniquePath();
    	System.out.println(path.uniquePaths(m,n));
    	System.out.println(path.uniquePathsWithObstacles(obstacle));
    }
}
