package LeetCode;

public class ReverseString {
	
	/*
	 * Seem to be right!!
	 */
    public String reverseWords_1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] c = s.toCharArray();
//    	for(int i = 0; i < c.length; i++) {
//        	System.out.print(c[i]);
//    	}
        char[] r = new char[c.length];
        int space = 0;
        for (int i = 0; i < c.length; i++) {
        	if (c[i] != ' ' && i != c.length - 1) {
        		continue;
        	} else if (c[i] == ' ' && space != 0){
            	int k = i - 1;
            	for (int j = space + 1; j < i; j++) {
            		r[j] = c[k];
            		k--;
            	}
            	r[i] = ' ';
            	space = i;
        	} else if (c[i] == ' ' && space == 0) {
            	int k = i - 1;
            	for (int j = 0; j < i; j++) {
            		r[j] = c[k];
            		k--;
            	}
            	r[i] = ' ';
            	space = i;
        	} else if (i == c.length - 1) {
            	int k = i;
            	for (int j = space + 1; j <= i; j++) {
            		r[j] = c[k];
            		k--;
            	}
            	//space = i;
        	}
        }
//    	for(int i = 0; i < r.length; i++) {
//        	System.out.print(r[i]);
//    	}
        char[] rst = new char[c.length];
        int j = rst.length - 1;
        for (int i = 0; i < r.length; i++) {
        	rst[j] = r[i];
        	j--;
        }
        
        StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < rst.length; i++) {
    		sb.append(rst[i]);
    	}
 //       String result = rst.toString();
        return sb.toString();
    }
    
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >=0; i--) {
        	if (!array[i].equals("")) {
        		sb.append(array[i]).append(" ");
        	}
        }
        return sb.length() == 0? "" : sb.substring(0, sb.length() - 1);
    }
    
    public static void main(String[] args) {
    	String in = "the sky is blue";
    	ReverseString rst = new ReverseString();
    	String out = rst.reverseWords_1(in);
    	System.out.println(in);
    	System.out.println(out);
    }
}
