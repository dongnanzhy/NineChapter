package MScompetition;

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
	
	public boolean isLetter (char a) {
		if (a >= '0' && a <= '9') {
			return true;
		} else if (a >= 'A' && a <= 'Z') {
			return true;
		} else if (a >= 'a' && a <= 'z') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValid (String s, int begin) {
		if (begin == 0) {
			if ( isLetter (s.charAt(begin)) ) 
				return true;
			else
				return false;
		} else if (!isLetter (s.charAt(begin - 1)) && isLetter (s.charAt(begin))) {
			return true;
		} else 
			return false;
	}
	
    public int palind (String s1, int begin1, String s2, int begin2) {
    	int length = 0;
    	while (begin1 < s1.length() && begin2 < s2.length()) {
    		while (begin1 < s1.length() && !isLetter(s1.charAt(begin1))) {
    			begin1++;
    		}
    		while (begin2 < s2.length() && !isLetter(s2.charAt(begin2))) {
    			begin2++;
    		}
    		if (begin1 >= s1.length() || begin2 >= s2.length()) {
    			break;
    		}
    		if (s1.charAt(begin1) != s2.charAt(begin2)) {
    			break;
    		} else {
        		begin1++;
        		begin2++;
        		length++;
    		}
    	}
    	return length;
    }
    
	public String output (String s) {
		String newS = s.toLowerCase();
		int maxL = 0;
		int size = s.length();
		int begin = 0; 
		int end = size - 1;
		String revS = reverseS(newS);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!isValid(newS,i) || !isValid(revS,j)) {
					continue;
				}
				int length = palind (newS,i, revS, j);
				if (length > maxL) {
					begin = i;
					end = size - j ;
					maxL = length;

				}
			}
		}
		return s.substring(begin, end);
	}
   
	  public static void main(String[] Args) throws FileNotFoundException {
		    Palindrome result = new Palindrome();
		    Scanner in = new Scanner(new File("src/JudgeInput.txt"));
		    while(in.hasNext()){
		       String str = in.nextLine();
//		       System.out.println(str);
		       System.out.println(result.output(str)); 
//		       System.out.println("sss");
		    }
		    in.close();
		  }
}
