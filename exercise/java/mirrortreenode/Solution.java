package mirrortreenode;

import java.util.*;

public class Solution {
		
	public static void main(String args[]) {
		
		Solution test = new Solution();
		TreeNode root = test.createTree1();
		
		TreeNode r = test.mirror3(root, test.target);
		
		System.out.println(r == null ? "null" : r.val);
	}
	
	TreeNode target;
	
	TreeNode createTree1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);

		
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
	
		//this.target = root.right.right;
		this.target = root.right;
		return root;
	}
	
	TreeNode mirror(TreeNode root, TreeNode target) {
		
		if (target == null) return null;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode n1 = queue.remove();
			TreeNode n2 = queue.remove();
			
			if (n1 == target)
				return n2;
			
			if (n2 == target)
				return n1;
			
			if (n1 != null && n2 != null) {
				queue.add(n1.left);
				queue.add(n2.right);
			
				queue.add(n1.right);
				queue.add(n2.left);
			}
		}
		
		return null;
	}
	
	TreeNode mirror2(TreeNode root, TreeNode target) {
		if (target == null)
			return null;
		
		found = false;
		String path = visit(root, target, "");
		
		if (path == null)
			return null;
		else {
			String path2 = "";
			for (char c : path.toCharArray()) {
				if (c == 'L')
					path2 += "R";
				else
					path2 += "L";
			}
				
			return check(root, target, path);
		}
	}
	
	private boolean found;
	
	String visit(TreeNode root, TreeNode target, String path) {
		if (root == null) return path;
		
		if (root == target) {
			found = true;
			return path;
		}
		
		String p = visit(root.left, target, path + "L");
		if (found) return p;
		
		p = visit(root.right, target, path + "R");
		if (found) 
			return p;
		else
			return null;
		
	}
	
	TreeNode check(TreeNode root, TreeNode target, String path) {
		TreeNode node = root;
		
		for (char c : path.toCharArray()) {
			if (node == null)
				return null;
			
			if (c == 'L')
				node = node.left;
			else
				node = node.right;
		}
		
		return node;
	}
	
	
	TreeNode mirror3(TreeNode root, TreeNode target) {
		if (root == null || target == null)
			return null;
		
		if (root == target) return root; 
		
		return findMirror(root.left, root.right, target);
	}
	
	TreeNode findMirror(TreeNode root1, TreeNode root2, TreeNode target) {
		if (root1 == null || root2 == null)
			return null;
		
		if (root1 == target)
			return root2;
		
		if (root2 == target)
			return root1;
		
		TreeNode m = findMirror(root1.left, root2.right, target);
		if (m != null)
			return m;
		
		return findMirror(root1.right, root2.left, target);
		
	}
}
