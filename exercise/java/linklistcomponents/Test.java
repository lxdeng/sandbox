package linklistcomponents;

public class Test {
	public static void main(String args[]) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
	
		Solution sol = new Solution();
		int group[] = {2, 3, 1, 0, 4};
		
		System.out.println(sol.numComponents(head, group));	
	}

}
