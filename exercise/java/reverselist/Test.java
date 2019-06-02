package reverselist;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();

		ListNode head = createList();

		/*
		ListNode r = sol.reverseBetween(head, 2, 4);
		if (r == null)
			System.out.println(r);
		else
			System.out.println(r.val);
		*/
		
		sol.reorderList(head);
		
		

	}

	static ListNode createList() {
		ListNode head = new ListNode(0);

		head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		
		return head;
	}

}
