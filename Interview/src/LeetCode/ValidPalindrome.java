package LeetCode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        String news = s.toLowerCase();
        int start = 0;
        int end = news.length() - 1;
        while (start < end) {
        	if (!isCharacter(news.charAt(start))) {
        		start++;
        		continue;
        	}
        	if (!isCharacter(news.charAt(end))) {
        		end--;
        		continue;
        	}
        	if (news.charAt(start) != news.charAt(end)) {
        		return false;
        	} else {
        		start++;
        		end--;
        		continue;
        	}
        }
        return true;
    }
    
    public boolean isCharacter (char c) {
    	if (c >= 'a' && c <= 'z') {
    		return true;
    	} else if (c >= 'A' && c <= 'Z') {
    		return true;
    	} else {
    		return false;
    	}
    }
}
