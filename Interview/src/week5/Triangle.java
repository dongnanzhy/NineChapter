package week5;
import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * @author dongnanzhy
 *
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
        	return 0;
        }
        int N = triangle.size();
        int[][] sum = new int [N][N];
        for (int i = 0; i < N; i ++) {
        	sum[N-1][i] = triangle.get(N-1).get(i);
        }
        // sum[i][j] means the minimum distance from (i,j) to the bottom.
        for (int i = N-2; i >=0; i--) {
        	for (int j = 0; j <=i; j++) {
        		sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) 
        				+ triangle.get(i).get(j);
        	}
        }
        return sum[0][0];
    }
}
