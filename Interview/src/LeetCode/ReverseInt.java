package LeetCode;

public class ReverseInt {
    public int reverse(int x) {
    	int rst = 0;
        while (x != 0) {
        	rst = rst * 10 + x % 10;
        	x = x / 10;
        	//int test = rst * 10 + x % 10;
        	if (rst > 0 && x!=0 && rst > Integer.MAX_VALUE / 10) {
        		//System.out.println(rst);
        		return 0;
        	}
        	if (rst < 0 && x!=0 && rst < Integer.MIN_VALUE / 10) {
        		//System.out.println(rst);
        		//System.out.println(Integer.MIN_VALUE);
        		return 0;
        	}
        }
        return rst;
    }
    public static void main (String []args) {
    	int in = -2147483412;
    	ReverseInt rst = new ReverseInt();
    	System.out.println(rst.reverse(in));
    }
}
