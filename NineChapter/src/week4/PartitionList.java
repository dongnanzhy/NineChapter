package week4;

import week4.BuildList.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example
 * Given 1->4->3->2->5->2 and x = 3
 * return 1->2->2->4->3->5.
 * @author dongnanzhy
 *
 */
public class PartitionList {
    // using left and right dummy!
	public ListNode partition(ListNode head, int x) {
        if (head == null) {
        	return head;
        }
        ListNode left_dummy = new ListNode(0);
        ListNode right_dummy = new ListNode(0);
        ListNode left = left_dummy;
        ListNode right = right_dummy;
        while (head != null) {
        	if (head.val < x) {
        		left.next = head;
        		left = left.next;
        	} else {
        		right.next = head;
        		right = right.next;
        	}
        	head = head.next;
        }
        right.next = null;
        left.next = right_dummy.next;
        return left_dummy.next;
    }
    
    public static void main (String[] args) {
    	int[] num = {1,4,3,2,5,2};
    	BuildList build = new BuildList();
    	ListNode head = build.buildList(num);
    	
    	PartitionList partition = new PartitionList();
    	ListNode result = new ListNode(0);
    	result = partition.partition(head, 3);
    	
    	build.print(result);
    }
}
