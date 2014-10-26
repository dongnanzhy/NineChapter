/*
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack.
 * 
 * 
 * public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return null;
        }
        int i, j;
        for(i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for(j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return haystack.substring(i);
            }
        }
        return null;
    }
  }
 */


package week1;

import java.util.Scanner;

public class Solution1 {
	public String strStr(String haystack,String needle){
		if(haystack == null || needle == null){
			return null;
		}
		boolean mark = true;
		for (int i = 0; i < haystack.length() - needle.length() +1; i++){
			for(int j = 0; j < needle.length(); j++){
				if(haystack.charAt(i+j) != needle.charAt(j)){
					mark = false;
					break;
				}
				mark = true;
			}
			if (mark){
				return haystack.substring(i);
			}
		}
		return null;
	}
	
	
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		Solution1 s = new Solution1();
		String haystack = input.nextLine();
		String needle = input.nextLine();
//		System.out.println( haystack );
		input.close();
		System.out.println( s.strStr(haystack,needle) );
	}
}

