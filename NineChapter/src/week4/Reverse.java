package week4;

import week4.BuildList.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * @author dongnanzhy
 */
public class Reverse {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode first = new ListNode(0);
        if (m == 1) {
        	first.next = head;
        	head = first;
        } else {
            first = findlist(head, m-1);	
        }
        ListNode start = first.next;
        ListNode temp_a = start;
        ListNode temp_b = start.next;
        ListNode temp_c;
        if (temp_b == null) {
        	temp_c = null;
        } else {
            temp_c = start.next.next;
        }


        for (int i = 0; i < n - m; i++) {
        	temp_b.next = start;
        	start = temp_b;
        	if (temp_c != null) {
            	temp_b = temp_c;
            	temp_c = temp_c.next;
        	} else {
        		temp_b = null;
        		temp_c = null;
        	}
        }
        first.next = start;
        temp_a.next = temp_b;
        if (m == 1) {
        	return head.next;
        } else {
            return head;	
        }
    }
    
    public ListNode findlist(ListNode head, int m) {
    	for (int i = m - 1; i > 0; i--) {
    		head = head.next;
    	}
    	return head;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	Reverse reverse = new Reverse();
    	ListNode result = new ListNode(0);
    	result = reverse.reverseBetween(head, 6, 8);
    	
    	build.print(result);
    }
}
