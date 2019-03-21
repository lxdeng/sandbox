package diameterofnarytree;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Node root = createTree();
		
		System.out.println(new Test().diameter(root));
	}
	
	public static Node createTree() {
		
		ArrayList<Node> list0 = new ArrayList<>();
		Node root = new Node(0, list0);
		
		ArrayList<Node> list1 = new ArrayList<>();
		Node n1 = new Node(1, list1);
		list0.add(n1);
		
		ArrayList<Node> list2 = new ArrayList<>();
		Node n2 = new Node(2, list2);
		list1.add(n2);
		
		ArrayList<Node> list3 = new ArrayList<>();
		Node n3 = new Node(3, list3);
		list2.add(n3);
		
		ArrayList<Node> list4 = new ArrayList<>();
		Node n4 = new Node(4, list4);
		list2.add(n4);
		
		ArrayList<Node> list5 = new ArrayList<>();
		Node n5 = new Node(5, list5);
		list4.add(n5);
		
		ArrayList<Node> list6 = new ArrayList<>();
		Node n6 = new Node(6, list6);
		list1.add(n6);
		
		ArrayList<Node> list7 = new ArrayList<>();
		Node n7 = new Node(7, list7);
		list6.add(n7);
		
		ArrayList<Node> list8 = new ArrayList<>();
		Node n8 = new Node(8, list8);
		list6.add(n8);
		
		ArrayList<Node> list9 = new ArrayList<>();
		Node n9 = new Node(9, list9);
		list2.add(n9);
		
		return root;
	}
	
	int max;
	// edges
	public int diameter(Node root) {
		
		height(root);
		
		return max;
	}
	
	private int height(Node root) {
		if (root == null) return 0;
		
		int h1 = 0, h2 = 0;
		for (Node ch : root.children) {
			int h = height(ch);
			if (h > h1) {
				h2 = h1;
				h1 = h;
			} else if (h > h2)
				h2 = h;
		}
		
		max = Math.max(max, h1 + h2);
		return Math.max(h1,  h2) + 1;
	}
	
}
