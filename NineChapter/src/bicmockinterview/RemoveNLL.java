package bicmockinterview;
import week4.BuildList;
import week4.SortList;
import week4.BuildList.ListNode;
/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * @author dongnanzhy
 *
 */
public class RemoveNLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
        	return head;
        }
    	ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
        	fast = fast.next;
        }
        if (null == fast) {
        	return head.next;
        }
        while (fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public static void main (String[] args) {
    	int[] num = {2,1,3,6,8,5,7,4};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	RemoveNLL remove = new RemoveNLL();
    	ListNode result = remove.removeNthFromEnd(head,8);
    	
    	build.print(result);
    }
}
