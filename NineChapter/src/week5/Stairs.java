package week5;

/**
 * You are climbing a stair case.
 *  It takes n steps to reach to the top.
 *  Each time you can either climb 1 or 2 steps. 
 *  In how many distinct ways can you climb to the top?
 * @author dongnanzhy
 *
 */
public class Stairs {
	public int climbStairs(int n) {
		if (n==1) {
			return 1;
		}
		if (n==2) {
			return 2;
		}
		if (n==0) {
			return 0;
		}
		int[] sum = new int[n];
		sum[0] = 1;
		sum[1] = 2;
		for (int i = 2; i < n; i++) {
			sum[i] = sum[i-1] + sum[i-2];
		}
		return sum[n-1];
	}
    public static void main (String[] args) {
    	
    	Stairs s = new Stairs();
    	System.out.println(s.climbStairs(4));
    }
}
