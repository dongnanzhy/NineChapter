package week4;

import week4.BuildList.ListNode;

public class RemoveDuplicate {
	
	/**
	 * 
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
        	if (head.next.val == head.next.next.val) {
        		head.next = head.next.next;
        	} else {
        		head = head.next;
        	}
        }
        return dummy.next;
    }
    
    /**
     * 
     * Given a sorted linked list, delete all nodes that have duplicate numbers, 
     * leaving only distinct numbers from the original list.
	 * For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.
     */
    public ListNode deleteDuplicates2(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	while (head.next != null && head.next.next != null) {
    		if (head.next.val == head.next.next.val) {
    			int val = head.next.val;
    			while (head.next != null && head.next.val == val) {     //Be attention here
    				head.next = head.next.next;
    			}
    		} else {
    			head = head.next;
    		}
    	}
    	return dummy.next;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,1,1,2};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	RemoveDuplicate delete = new RemoveDuplicate();
    	ListNode result = new ListNode(0);
    	result = delete.deleteDuplicates2(head);
    	
    	build.print(result);
    }
}
