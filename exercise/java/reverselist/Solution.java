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
	
	
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        //find middle node
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // cut from middle
        ListNode head2 = slow.next;
        slow.next = null;
        
        //reverse the bottom half
        ListNode rHead = null;
        ListNode p;
        while (head2 != null) {
            p = head2;
            head2 = head2.next;
            
            p.next = rHead;
            rHead = p;
        }
        
        // merge
        while (rHead != null) {
            p = rHead;
            rHead = rHead.next;
            
            p.next = head.next;
            head.next = p;
            head = head.next.next;
        }
    }
}