package Competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome {
	
	public String reverseS(String source) {
	    int i, len = source.length();
	    StringBuilder dest = new StringBuilder(len);

	    for (i = (len - 1); i >= 0; i--){
	        dest.append(source.charAt(i));
	    }

	    return dest.toString();
	}
	
	public String output (String s) {
		String newS = s.toLowerCase();
		int maxL = 0;
		int size = s.length();
		int begin = 0;
		String revS = reverseS(newS);
		for (int i = 0; i < size; i++) {
			for (int j =0; j < size; j++) {
				if (!isLetter(newS.charAt(i)) || !isLetter(revS.charAt(j))) {
					continue;
				}
				int length = palind (newS, i, revS, j);
				if (length > maxL) {
					begin = i;
					maxL = length;
				}
			}
		}
		return s.substring(begin, begin + maxL);
	}
	
	public boolean isLetter (char a) {
		if (a < 'A') {
			return false;
		} else if (a > 'Z' && a < 'a') {
			return false;
		} else if (a > 'z') {
			return false;
		} else {
			return true;
		}
	}
	
    public int palind (String s1, int begin1, String s2, int begin2) {
    	int length = 0;
    	while (begin1 < s1.length() && begin2 < s2.length()) {
    		while (begin1 < s1.length() && !isLetter(s1.charAt(begin1))) {
    			begin1++;
    			length++;
    		}
    		while (begin2 < s2.length() && !isLetter(s2.charAt(begin2))) {
    			begin2++;
    			length++;
    		}
    		if (begin1 >= s1.length() || begin2 >= s2.length()) {
    			break;
    		}
    		if (s1.charAt(begin1) != s2.charAt(begin2)) {
    			break;
    		}
    		while (s1.charAt(begin1) == s2.charAt(begin2)) {
        		begin1++;
        		begin2++;
        		length++;
        		if (begin1 >= s1.length() || begin2 >= s2.length()) {
        			break;
        		}
    		}
    	}
    	return length;
    }   
    
	  public static void main(String[] Args) throws FileNotFoundException {
		    Palindrome result = new Palindrome();
		    Scanner in = new Scanner(new File("src/JudgeInput.txt"));
		    while(in.hasNext()){
		       String str = in.nextLine();
		       System.out.println(result.output(str));    
		    }
		  }
}
