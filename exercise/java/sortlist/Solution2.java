package sortlist;

public class Solution2 {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        
        for (int step = 1; step < n; step *= 2) {
            ListNode tail = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                tail = merge(left, right, tail);
            } 
        }
        
        return dummy.next;
    }
    
    /*
	 * Divide the linked list into two lists,
     * while the first list contains first n nodes
	 * return the second list's head
	 */
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
    	
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
     /*
	  * merge the two sorted linked list left and right,
	  * then append the merged sorted linked list to the node head
	  * return the tail of the merged sorted linked list
	 */
    private ListNode merge(ListNode left, ListNode right, ListNode tail) {
        ListNode cur = tail;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null) 
        	cur.next = left;
        else if (right != null) 
        	cur.next = right;
        
        while (cur.next != null) cur = cur.next;
        
        return cur;
    }
    
}