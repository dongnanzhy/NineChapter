package week4;
import week4.BuildList.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author dongnanzhy
 *
 */

public class SortList {
	// using slow and fast pointer to find the mid of List
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
	
	// merge two sorted List
	public ListNode merge (ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				head.next = head1;
				head1 = head1.next;
			} else {
				head.next = head2;
				head2 = head2.next;
			}
			head = head.next;
		}
		if (head1 != null) {
			head.next = head1;
		}
		if (head2 != null) {
			head.next = head2;
		}
		return dummy.next;
	}
	
	// merge sort using recursion
	public ListNode sortList (ListNode head) {
	    if (head == null || head.next == null) {
	    	return head;
	    }
		ListNode mid = findmid(head);
	    ListNode right = sortList(mid.next);
	    mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}
	
    public static void main (String[] args) {
    	int[] num = {2,1,3,6,8,5,7,4};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	SortList sort = new SortList();
    	ListNode result = sort.sortList(head);
    	
    	build.print(result);
    }
}
