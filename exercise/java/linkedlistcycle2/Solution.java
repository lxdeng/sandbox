package linkedlistcycle2;

import java.util.HashSet;

class Solution {
	public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(true) {
            for (int i = 0; i < 2; i++) {
              fast = fast.next;
              if (fast == null) return null;
              if (fast == slow) return searchFirst(head, slow); //slow in one of the nodes in the cycle
            }
            slow = slow.next;
        }
    }
    
    ListNode searchFirst(ListNode head, ListNode slow) {
        HashSet<ListNode> set = new HashSet<>();
              
        while(true) {
            set.add(head);
            if (head == slow)
            	break;
            else
            	head = head.next;
        }
        
        ListNode current = slow.next;
        
        while(true) {
            if (set.contains(current))
                return current;
            else
                current = current.next;
        }
        
    }
}