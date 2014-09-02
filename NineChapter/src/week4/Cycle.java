package week4;
import week4.BuildList.ListNode;

// using fast and slow pointer to detect cycle;
public class Cycle {

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * Follow up:
	 * Can you solve it without using extra space?
	 */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
        	if (fast == slow) {
        		return true;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return false;
    }
    
    /**
     * Given a linked list, return the node where the cycle begins. 
     * If there is no cycle, return null.
     * Follow up:
     * Can you solve it without using extra space?
     */  
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
        	return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
        	if (fast == null || fast.next == null) {
        		return null;
        	}
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
        }
		return slow;
    }
}
