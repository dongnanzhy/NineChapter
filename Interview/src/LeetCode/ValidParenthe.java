package LeetCode;

import java.util.Stack;

public class ValidParenthe {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(' || c == '{' || c == '[') {
        		stack.push(c);
        	} else {
        		if (stack.isEmpty()) {
        			return false;
        		}
        		char prev = stack.pop();
        		if (c == ')') {
        			if (prev == '(') {
        				continue;
        			} else {
        				return false;
        			}
        		} else if (c == '}') {
        			if (prev == '{') {
        				continue;
        			} else {
        				return false;
        			}
        		} else if (c == ']') {
        			if (prev == '[') {
        				continue;
        			} else {
        				return false;
        			}
        		}
        	}
        }
        if (stack.isEmpty()) {
        	return true;
        } else {
        	return false;
        }
    }
}
