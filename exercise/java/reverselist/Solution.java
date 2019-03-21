package reverselist;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode tail = dummy;
        
        for (int i = 0; i < m - 1; i++)
            tail = tail.next;
        
        // cur is at the m position
        ListNode cur = tail.next;
        ListNode saved = cur;
        tail.next = null;
        
        for (int i = 0; i < n - m + 1; i++) {
            ListNode p = cur;
            cur = cur.next;
            
            p.next = tail.next;
            tail.next = p;
        }
        
        saved.next = cur;
        return dummy.next;
    }
}