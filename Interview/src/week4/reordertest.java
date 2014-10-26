package week4;
import week4.BuildList.ListNode;

public class reordertest {
	public ListNode findmid (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse (ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}

	public ListNode merge (ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		boolean test = true;
		while (head1 != null && head2 != null) {
			if (test) {
				head.next = head1;
				head1 = head1.next;
			} else {
				head.next = head2;
				head2 = head2.next;
			}
			head = head.next;
			test = !test;
		}
		if (head1 != null) {
			head.next = head1;
		}
		if (head2 != null) {
			head.next = head2;
		}
		return head.next;
	}

	public ListNode reorder (ListNode head) {
		ListNode mid = findmid(head);
		ListNode right = mid.next;
		mid.next = null;
		ListNode left = head;
		right = reverse(right);
		head = merge(left, right);
		return head;
	}
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	reordertest reordertest = new reordertest();
//   	ListNode result = new ListNode(0);
//    	result = reorder.reverse(head);
    	reordertest.reorder(head);
    	build.print(head);
    }
}
