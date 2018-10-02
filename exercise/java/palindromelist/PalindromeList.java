package palindromelist;

public class PalindromeList {

	public static void main(String args[]) {
		Solution sol = new PalindromeList().new Solution();
		
		ListNode head = createList();
		System.out.println(sol.isPalindrome(head));
		
		
	}
	
	private static ListNode createList() {
		return new ListNode(1);
	}
	
	class Solution {
	    public boolean isPalindrome(ListNode head) {
	        ListNode reversed = null;
	        
	        ListNode p = head;
	        while (p != null) {
	            ListNode node = new ListNode(p.val);
	            node.next = reversed;
	            reversed = node;
	            p = p.next;
	        }
	        
	        while (head != null) {
	            if (reversed == null || reversed.val != head.val) return false;
	                
	            reversed = reversed.next;
	            head = head.next;
	        }
	        
	        return true;
	    }
	}
	
	
}
