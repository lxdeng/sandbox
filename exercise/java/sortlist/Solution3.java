package sortlist;

public class Solution3 {
	
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        
        ListNode tail = dummy;
        ListNode cur, left, right;
        for (int step = 1; step < size; step *= 2) {// 1, 2, 4, 8, ....
            cur = dummy.next;
            while (cur != null) {
                left = cur;
                right = split(cur, step);
                cur = split(right, step); // cur points the start of the next step
                tail = merge(left, right, tail);
            }
        }
        
        return dummy.next;
    }
    
    ListNode split(ListNode start, int step) {
        for (int i = 0; i < step-1; i++) {
            if (start != null) 
                start = start.next;
            else
                break;
        }
        
        if (start == null) return null;
        
        ListNode node = start.next;
        start.next = null;
        return node;
    }
    
    // merge left and right, after tail
    // tail moves to the new end
    ListNode merge(ListNode left, ListNode right, ListNode tail) {
        ListNode p;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p = left;    
                left = left.next;
            } else {
                p = right;
                right = right.next;
            }
            
            tail.next = p;
            tail = tail.next;
        }
        
        if (left != null) {
            tail.next = left;
        }
        
        if (right != null) {
            tail.next = right;
        }
        
        while (tail.next != null) tail = tail.next;
        
        return tail;
    }
    
}