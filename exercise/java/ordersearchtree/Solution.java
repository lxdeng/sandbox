package ordersearchtree;

public class Solution {

  public static void main(String args[]) {
	  TreeNode root = new TreeNode(5);
	  
	  root.left = new TreeNode(3);
	  root.right = new TreeNode(6);
	  
	  root.left.left = new TreeNode(2);
	  root.left.left.left = new TreeNode(1);

	  root.left.right = new TreeNode(4);
	  
	  
	  root.right.right = new TreeNode(8);
	  root.right.right.left = new TreeNode(7);
	  root.right.right.right = new TreeNode(9);

	  
	  Solution sol = new Solution();
	  
	  TreeNode t = sol.increasingBST(root);
	  
	  System.out.println();
	  System.out.println(t.val);
	  
  }
	
  TreeNode head = new TreeNode(0);
  TreeNode tail = head;
  
  public TreeNode increasingBST(TreeNode root) {
      visit(root);
      return head.right;
  }
  
  void visit(TreeNode root) {
      if (root == null)
          return;
      
      visit(root.left);
      System.out.println(root.val);
      tail.right = root;
      tail = root;
      visit(root.right);
  }
}
