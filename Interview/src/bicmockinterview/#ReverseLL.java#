package bicmockinterview;
import week4.BuildList;
import week4.BuildList.ListNode;

public class ReverseLL {
	public ListNode reverse_ll(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}
		ListNode newHead = reverse_ll(head.next); //reverse one node at one time.
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public ListNode reverse_loop (ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp;
		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8};
    	int[] num2 = {1,2,3,4,5,6,7,8};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	ListNode head2 = build.buildList(num2);
    	
    	ReverseLL reverse = new ReverseLL();
    	
    	ListNode result = new ListNode(0);
    	result = reverse.reverse_ll(head);
    	
    	ListNode result2 = new ListNode(0);
    	result2 = reverse.reverse_loop(head2);
    	
    	build.print(result);
    	System.out.println();
    	build.print(result2);
    }
}
