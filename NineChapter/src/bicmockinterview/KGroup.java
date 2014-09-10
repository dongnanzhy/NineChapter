package bicmockinterview;
import week4.BuildList;
import week4.BuildList.ListNode;

public class KGroup {
    public ListNode reverseK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = new ListNode(0);
        int count = 0;
/*        for (int i = 0; i < k; i++) {
        	ListNode H = head;
        	if (head == null) {
        		return H;
        	}
        	head = head.next;
        }*/
        while (curr != null && count < k) {
        	temp = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = temp;
        	count++;
        }
        if (temp != null) {
        	head.next = reverseK(curr, k);
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = new ListNode(0);
        int count = 0;
/*        for (int i = 0; i < k; i++) {
        	ListNode H = head;
        	if (head == null) {
        		return H;
        	}
        	head = head.next;
        }*/
        while (curr != null && count < k) {
        	temp = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = temp;
        	count++;
        }
        if (temp != null) {
        	head.next = reverseK(curr, k);
        }
        return prev;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	KGroup kgroup = new KGroup();
    	
    	ListNode result = new ListNode(0);
    	result = kgroup.reverseK(head,3);
    	
    	build.print(result);
    	System.out.println();
    }
}

