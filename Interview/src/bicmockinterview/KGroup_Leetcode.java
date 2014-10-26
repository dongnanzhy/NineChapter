package bicmockinterview;
import week4.BuildList;
import week4.BuildList.ListNode;

public class KGroup_Leetcode {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre,head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     * after call pre = reverse(pre, next)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre 
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,2,3,4,5,6,7,8};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	KGroup_Leetcode kgroup = new KGroup_Leetcode();
    	
    	ListNode result = new ListNode(0);
    	result = kgroup.reverseKGroup(head,3);
    	
    	build.print(result);
    	System.out.println();
    }
}
