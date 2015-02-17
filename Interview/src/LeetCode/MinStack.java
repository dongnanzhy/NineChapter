package LeetCode;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> stack_min = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (!stack_min.isEmpty()) {
        	if (x <= stack_min.peek()) {
        		stack_min.push(x);
        	}
        } else {
        	stack_min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
        	return;
        } else {
        	if (stack.peek().equals(stack_min.peek())) {
        		stack.pop();
        		stack_min.pop();
        	} else {
        		stack.pop();
        	}
        }
    }

    public int top() {
        if (stack.isEmpty()) {
        	return 0;
        } else {
        	int top = stack.peek();
        	return top;
        }
    }

    public int getMin() {
        if (stack_min.isEmpty()) {
        	return 0;
        } else {
        	int min = stack_min.peek();
        	return min;
        }
    }
}
