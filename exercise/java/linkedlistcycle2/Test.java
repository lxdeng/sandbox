package linkedlistcycle2;

public class Test {
	public static void main(String args[]) {
		/*
		int nums[] = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
			//	tail connects to node index 24
		
		ListNode prev = null;
		ListNode tail = null;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(nums[i]);
			if (prev == null)
				tail = node;
			
			node.next = prev;
			prev = node;
		}
		
		ListNode head = prev;
		
		for (int i = 0; i < 24; i++) {
			prev = prev.next;
		}
		
		tail.next = prev;
		System.out.println(prev.val);
		*/
		
		ListNode head = new ListNode(1);
		head.next = head;
		
		Solution sol = new Solution();
		ListNode start = sol.detectCycle(head);
		System.out.println(start.val);
		
	}

}
