//import java.util.ArrayList;
//import java.util.List;

public class PathSum3 {

	  public static void main(String[] args) {

		  Solution sol = new PathSum3().new Solution();
		  //TreeNode t1 = createTree1();
		  //TreeNode t2 = createTree2();
		  TreeNode t3 = createTree3();
		  System.out.println("count=" + sol.pathSum(t3,8));
		  
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
		    public int pathSum(TreeNode root, int sum) {        
		       if (root == null) return 0;
		       
		       return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFromRoot(root, sum);	
		    }
		    
		    public int pathSumFromRoot(TreeNode root, int sum) {
		    	if (root == null) return 0;
		    	
		    	return pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum-root.val) + (root.val == sum? 1 : 0);		    	
		    }
		    
		    
		}
}
