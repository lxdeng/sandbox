//import java.util.ArrayList;
//import java.util.List;

public class PathSum {

	  public static void main(String[] args) {

		  Solution sol = new PathSum().new Solution();
		  //TreeNode t1 = createTree1();
		  TreeNode t2 = createTree2();
		  //TreeNode t3 = createTree3();
		  System.out.println(sol.hasPathSum(t2, 1));
		  
	  }
	  
	  static TreeNode createTree1() {
		  TreeNode root = new TreeNode(1);
		  return root;
	  }
	  
	  static TreeNode createTree2() {
		  TreeNode root = new TreeNode(1);
		  root.left = new TreeNode(2);
		  return root;
	  }
	  
	  private static TreeNode createTree3() {
		  TreeNode root = new TreeNode(10);

		  root.left = new TreeNode(5);
		  root.right = new TreeNode(-3);
		  
		  root.left.left = new TreeNode(3);
		  root.left.right = new TreeNode(2);
		  
		  root.right.right = new TreeNode(11);
		  
		  root.left.left.left = new TreeNode(3);
		  root.left.left.right = new TreeNode(-2);
		  
		  root.left.right.right = new TreeNode(1);
				  
		  return root;
	  }
	  
	  class Path {
		  String path;
		  int sum;
		  Path(String p, int sum) {
			  this.path = p;
			  this.sum = sum;					  
		  }
	  }
	  
	  class Solution {
		  
		    
		    public boolean hasPathSum(TreeNode root, int sum) {
		        if (root == null) return false;

		        return dfs(root, sum);
		    }
		    
		    boolean dfs(TreeNode root, int sum) {

		        if (root.left == null && root.right == null) {        	
		        	return root.val == sum;
		        }
		     
		        if (root.left != null && dfs(root.left, sum - root.val)) 
		        	return true;

		        if (root.right != null && dfs(root.right, sum - root.val)) 
		        	return true;
		        
		        return false;
		    }
		    
		}
}
