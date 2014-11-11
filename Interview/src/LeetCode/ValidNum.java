package LeetCode;


public class ValidNum {
    public boolean isNumber(String s) {
        if (s.isEmpty()) {
        	return false;
        }
        
        String rex = "^[0-9]*$";
 //       String rex2 = ;
        if (s.matches(rex)) {
        	return true;
        }
       return false; 
    }
    
    public static void main (String[] args) {
    	String s = " 09";
    	ValidNum v = new ValidNum();
    	System.out.println(v.isNumber(s));
    }
}
