package week8;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
    	if (num == null || num.length < 3) {
        	return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int rst = Integer.MAX_VALUE / 2;
        
        for (int i = 0; i < num.length - 2; i++) {
        	int left = i + 1;
        	int right = num.length - 1;
        	while (left < right) {
            	int sum = num[left] + num[right] + num[i];
            	if (sum == target) {
            		return sum;
            	} else if (sum < target) {
            		left++;
            	} else {
            		right--;
            	}
            	rst = (Math.abs(sum - target) < Math.abs(rst - target))? sum : rst;
        	}
        }
        return rst;
    }
    
    public static void main (String[] args) {
    	int[] A = {-1, 2, 1, -4};
    	ThreeSumClosest result = new ThreeSumClosest();
    	System.out.println(result.threeSumClosest(A, 1));
    }
}
