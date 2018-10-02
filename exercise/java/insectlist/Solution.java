package insectlist;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;

		ListNode p = headA;
		ListNode q = headB;

		boolean redirectToB = true;
		boolean redirectToA = true;

		while (true) {
			if (p != null)
				p = p.next;
			else if (redirectToB) {
				p = headB;
				redirectToB = false;
			} else {
				return null;
			}

			if (p == q)
				return p;

			if (q != null)
				q = q.next;
			else if (redirectToA) {
				q = headA;
				redirectToA = false;
			} else {
				return null;
			}
			if (p == q)
				return p;

		}

	}
}