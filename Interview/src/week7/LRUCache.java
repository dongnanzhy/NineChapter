package week7;

import java.util.HashMap;

public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
		public Node (int key, int value) {
			this.prev = null;
			this.next = null;
			this.key = key;
			this.value = value;
		}	
	}
	
	/** 
	 * private attribute capacity 
	 * hash map 
	 * Head and Tail
	 */
	private int capacity;
	private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
	private Node head = new Node(-1,-1);
	private Node tail = new Node(-1,-1);
	
	/**
	 * Construct Method.  Make head point to tail and tail point back to head.
	 * @param capacity
	 */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
	/**
	 * if key doesn't exists, return -1.
	 * if key exists, remove it from the list and move it before tail(recently used). Then return its value.
	 * @param ket
	 */
    public int get(int key) {
        if (!hs.containsKey(key)) {
        	return -1;
        }
        
        Node curr = hs.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        moveToTail (curr);
        
        return hs.get(key).value;  
    }
    
    /**
     * if key exists, set its value and return
     * if key doesn't exists, if capacity is full, remove LRU(just after head) and insert new node to tail,
     * otherwise insert new node to tail directly.
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        if (get(key) != -1) {
        	hs.get(key).value = value;
        	return;
        }
        
        if (hs.size() == capacity) {
        	hs.remove(head.next.key);
        	head.next = head.next.next;
        	head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        hs.put(key, insert);
        moveToTail (insert);
    }
    
    /**
     * move a Node before tail, recently used.
     * @param curr
     */
    private void moveToTail (Node curr) {
    	tail.prev.next = curr;
    	curr.prev = tail.prev;
    	tail.prev = curr;
    	curr.next = tail;
    	
    }
}
