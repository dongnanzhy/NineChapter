/**
 * Implement pow(x, n). O(lgn) Run Time
 */

package LeetCode;

public class Pow {
    public double pow(double x, int n) {
        if (n == 0) {
        	return 1.0;
        }
        if (n < 0) {
        	x = 1/x;
        	n = -n;
        }
        if (n == 1) {
        	return x;
        }

        if (n % 2 == 0) {
        	double res = pow(x, n/2);
        	return res * res;
        } else {
        	n = n - 1;
        	double res = pow(x, n/2);
        	return x * res * res;
        }
//        return 0.0;
    }
    
    public static void main (String[] args) {
    	Pow p = new Pow();
    	System.out.println(p.pow(2.0, -2));
    }
    
}
