package week4;
import week4.BuildList.ListNode;;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author dongnanzhy
 *
 */
public class Reorder {
    public ListNode findmid (ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
    
    public ListNode reverse (ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;
    	ListNode temp_a = head.next;
    	ListNode start = temp_a;
    	ListNode temp_b = temp_a.next;
    	ListNode temp_c = temp_b.next;
    	while (temp_b != null) {
    		temp_b.next = temp_a;
    		temp_a = temp_b;
        	if (temp_c != null) {
            	temp_b = temp_c;
            	temp_c = temp_c.next;
        	} else {
        		temp_b = null;
        		temp_c = null;
        	}
    	}
    	dummy.next = temp_a;
    	start.next = null;
    	return dummy.next;
    }
    
	public void reorderList (ListNode head) {
		if (head == null) {
			return;
		}
		ListNode mid = findmid(head);
		ListNode right = mid.next;
		mid.next = null;
		ListNode left = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		right = reverse(right);
		
		boolean test = true;
		while (left != null && right != null) {
			if (test) {
				head.next = left;
				left = left.next;
			} else {
				head.next = right;
				right = right.next;
			}
			test = !test;
			head = head.next;
		}
		if (left != null) {
			head.next = left;
		}
		if (right != null) {
			head.next = right;
		}
		head = dummy.next;
    }
	
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	Reorder reorder = new Reorder();
//   	ListNode result = new ListNode(0);
//    	result = reorder.reverse(head);
    	reorder.reorderList(head);
    	build.print(head);
    }
}
