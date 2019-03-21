package sortlist;

public class SortList {
	
	public static void main(String args[]) {
		ListNode head = createList();
		Solution3 sol = new Solution3();
		head = sol.sortList(head);
		printList(head);
	}
	
	static ListNode createList() {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		return head;
	}
	
	static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
