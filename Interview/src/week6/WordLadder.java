package week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
        	return 0;
        }
        Queue<String> que = new LinkedList<String>(); 
        que.offer(start);
        dict.remove(start);
        int length = 1;
        //BFS 
        while(!que.isEmpty()) {
        	int size = que.size();
        	for (int i = 0; i < size; i++) {
        		String current = que.poll();
        		for (char j = 'a'; j <= 'z'; j++) {
        			for (int k = 0; k < current.length(); k++) {
        				if (current.charAt(k) == j) {
        					continue;
        				}
        				String tmp = replace(current, k, j);
        				if (tmp.equals(end)) {
        					return length + 1;
        				}
        				if (dict.contains(tmp)) {
        					que.offer(tmp);
        					dict.remove(tmp);
        				}
        			}
        		}
        	}
        	length++;
        }
    	return 0;
    }
    
    private String replace(String s, int index, char c) {
    	char[] tmp = s.toCharArray();
    	tmp[index] = c;
    	return new String(tmp);
    }
}
