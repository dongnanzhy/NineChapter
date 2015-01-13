package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
        	return null;
        }
        dict.add(start);
        dict.add(end);
        ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        
        bfs(map, distance, start, end, dict);
        ArrayList<String> path = new ArrayList<String>();
        dfs(ladders, path, map, distance, start, end);
        return ladders;
    }
    
    private void bfs(HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance, 
    		String start, String end, Set<String> dict) {
    	Queue<String> que = new LinkedList<String>();
    	que.offer(start);
    	distance.put(start, 0);
    	for (String s : dict) {
    		map.put(s, new ArrayList<String>());
    	}
    	
    	while(!que.isEmpty()) {
    		String cur = que.poll();
    		ArrayList<String> nextString = expand(cur, dict);
    		for (String next : nextString) {
    			map.get(next).add(cur);
    			if (!distance.containsKey(next)) {
    				distance.put(next, distance.get(cur) + 1);
    				que.offer(next);
    			}
    		}
    	}
    }
    
    private void dfs(ArrayList<ArrayList<String>> ladders, ArrayList<String> path, 
    		HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance, 
    		String start, String cur) {
    	path.add(cur);
    	if (cur.equals(start)) {
    		Collections.reverse(path);
    		ladders.add(new ArrayList<String>(path));
    		Collections.reverse(path);
    	} else {
    		for (String next : map.get(cur)) {
    			if (distance.containsKey(next) && distance.get(cur) == distance.get(next) + 1) {
    				dfs(ladders, path, map, distance, start, next);
    			}
    		}
    	}
		path.remove(path.size() - 1);
    }
    
    private ArrayList<String> expand(String cur, Set<String> dict) {
    	ArrayList<String> list = new ArrayList<String>();
    	for (int i = 0; i < cur.length(); i++) {
    		for (char ch = 'a'; ch <= 'z'; ch++) {
    			if (ch != cur.charAt(i)) {
        			String tmp = cur.substring(0, i) + ch + cur.substring(i + 1);
        			if (dict.contains(tmp)) {
        				list.add(tmp);
        			}
    			}
    		}
    	}
    	return list;
    }
    
    
}
