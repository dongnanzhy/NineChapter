package week5;

import java.util.Set;

public class WordBreak {
	
	/*
	 * Given a string s and a dictionary of words dict, 
	 * determine if s can be segmented into a space-separated sequence of one or more dictionary words
	 */
	public int getMaxLength (Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        boolean[] canSeg = new boolean[s.length() + 1];
        canSeg[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	canSeg[i] = false;
        	// j represents for travel from right to left of the string.
        	for (int j = 1; j <= getMaxLength (dict) && j <= i; j++) {
        		if (!canSeg[i-j]) {
        			continue;
        		}
        		String word = s.substring(i-j, i);
        		if (dict.contains(word)) {
        			canSeg[i] = true;
        			break;
        		}
        	}
        }
        return canSeg[s.length()];
    }
    
    
}
