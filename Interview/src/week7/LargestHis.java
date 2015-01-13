package week7;

import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestHis {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
        	return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
        	int cur = (i == height.length) ? -1 : height[i];
        	while (!stack.isEmpty() && cur <= height[stack.peek()]) {
        		int h = height[stack.pop()];
        		int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
        		max = Math.max(max, h * w);
        	}
        	stack.push(i);
        }
        return max;
    }
}
