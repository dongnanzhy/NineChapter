package week4;

//import java.util.*;


public class BuildList {
	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	 
    public ListNode buildList (int[] num) {
    	int size = num.length;
    	if (size == 0) {
    		return null;
    	}
    	ListNode head = new ListNode(num[0]);
    	ListNode node = head;
    	for (int i = 1; i < size; i++) {
    		ListNode current = new ListNode(num[i]);
    		node.next = current;
    		node = current;
    	}
    	node.next = null;
    	return head;
    }
    
    public void print(ListNode head) {
    	if (head == null) {
    		System.out.println("null");
    		return;
    	}
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	return;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	build.print(head);
//    	System.out.println(list.next.next.next.val);
    }
}
