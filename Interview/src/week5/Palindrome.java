
package week5;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra space
	 */
    public boolean isPalindrome(int x) {
    	if (x < 0)
    		return false;
    	return x == reverse(x);
    }
    public int reverse(int x) {
    	if (x < 0)
    		return 0;
    	int rst = 0;
    	while (x > 0) {
    		rst = rst * 10 + x % 10;
    		x = x /10;
    	}
    	return rst;
    }
    
    /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return all possible palindrome partitioning of s.
     * For example, given s = "aab",
     * Return
     * [ ["aa","b"],
    	 ["a","a","b"] ]
     */
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> rst = new ArrayList<List<String>>();
        if (s.isEmpty()) {
        	return null;
        }
//        if (isPalind(s)) {
//            ArrayList<String> list = new ArrayList<String>();
//        	list.add(s);
//        	rst.add(list);
//        }
        ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < s.length()-1; i++) {
//        	s1 = s.substring(0, i);
//        	s2 = s.substring(i+1, s.length()-1);
//        	if (isPalind(s1) && isPalind(s2) ) {
//                ArrayList<String> list = new ArrayList<String>();
//                list.add(s1);
//                list.add(s2);
//                rst.add(list);
//        	}
//        }
        helper(s, list, 0, rst);
        return rst;
    }
    public boolean isPalind (String s) {
    	int begin = 0;
    	int end = s.length() - 1;
    	while (begin < end) {
    		if (s.charAt(begin) != s.charAt(end)) {
    			return false;
    		}
    		begin++;
    		end--;
    	}
    	return true;
    }
    public void helper (String s, ArrayList<String> list, int pos, ArrayList<List<String>> rst) {
    	if (pos == s.length()) {
    		rst.add(new ArrayList<String>(list));
    		return;
    	}
    	for (int i = pos + 1; i <= s.length(); i++) {
    		String prefix = s.substring(pos, i);
    		if (!isPalind (prefix)) {
    			continue;
    		}
    		list.add(prefix);
    		helper(s,list,i,rst);
    		list.remove(list.size() - 1);		
    	}
    }
    
    /*
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * For example, given s = "aab",
     * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     * 
     * 
     * Time out!!!!!!! Need to improve!!
     */
    public int minCut(String s) {
        return numCut(s,s.length());
    }
    public int numCut (String s, int pos) {
    	if (pos == 0) {
    		return 0;
    	}
		int min = 100000;
    	for (int i = 0; i < pos; i++) {
    		String sub = s.substring(i+1, pos);
    		if (isPalind(sub)) {
    			int num = numCut(s,i);
    			if (num < min) {
    				min = num;
    			}
    		}
    	}
    	String sub = s.substring(0, pos);
		if (isPalind(sub)) {
			return 0;
		}
    	return min + 1;
    	
    }
    
    public static void main (String[] args) {
 //   	int x = 131000;
    	String s = "abc";
    	Palindrome res = new Palindrome();
    	System.out.println(res.minCut(s));
    }
}
