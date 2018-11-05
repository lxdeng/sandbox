package sortlist;

public class Solution {
    public ListNode sortList(ListNode head) {
        int size = size(head);        
        return sortList(head, size);
    }
    
    private int size(ListNode head) {
        if (head == null) return 0;
        
        int size = 0;
        
        while(head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    private ListNode sortList(ListNode head, int size) {
        if (size <= 1) return head;
        
        int half = size/2;
        
        ListNode node = head;
        for (int i = 0; i < half - 1; i++) {
            node = node.next;
        }
        
        ListNode list2 = node.next;
        node.next = null;
        
        ListNode h1 = sortList(head, half);
        ListNode h2 = sortList(list2, size - half);
        
        return mergeList(h1, h2);
    }
    
    private ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        
        // tail.next = null; // terminate not needed here, since one of h1 or h1 has at least one left
        
        if (h1 != null) {
            tail.next = h1;
        } else  if (h2 != null) {
            tail.next = h2;
        }
        
        return dummy.next;
    }
    
}