package LeetCode;

public class Prefix {
    /*
     * Write a function to find the longest common prefix string amongst an array of strings
     */
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) {
    		return "";
    	}
        int size = strs.length;
        int end = 1;
        boolean test = true;
        while (isValid (strs, end)) {
        	String temp = strs[0].substring(0, end);
        	for (int i = 1; i < size; i++) {
        		if (!strs[i].substring(0, end).equals(temp)) {
        			test = false;
        			break;
        		}
        	}
        	if (test) {
            	end++;
        	} else {
        		break;
        	}
        }
        if ( end == 1 && !test) {
 //       	System.out.println("#####");
        	return "";
        } else{
//        	System.out.println(end);
            return strs[0].substring(0, end - 1);
        } 
    }
    
    public boolean isValid (String[] strs, int index) {
        int size = strs.length;
    	for (int i = 0; i < size; i ++) {
    		if (index > strs[i].length()) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	String[] strs = {"abcdef","abcde","abdd","abc","a","abcdefg"};
    	Prefix res = new Prefix();
    	System.out.println (res.longestCommonPrefix(strs));
    }
}
