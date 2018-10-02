package insectlist;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();

		ListNode[] heads = createLists();
		ListNode headA = heads[0];
		ListNode headB = heads[1];

		ListNode r = sol.getIntersectionNode(headA, headB);
		if (r == null)
			System.out.println(r);
		else
			System.out.println(r.val);

	}

	static ListNode[] createLists() {
		ListNode[] heads = new ListNode[2];

		heads[0] = new ListNode(1);

		heads[1] = new ListNode(2);
		heads[1].next = heads[0];

		return heads;
	}

}
