
public class SubTree {
    public static void main(String[] args) {


      Solution sol = new SubTree().new Solution();
      
      
      
      TreeNode s = createTree1();
      //TreeNode t = createTree2();
      
      //TreeNode s = createTree();
      //TreeNode t = createTree1();
      
      //TreeNode s = createTree0();
      System.out.println(sol.isSubtree(s, s));
    }
    
    public static TreeNode createTree0() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }

    public static TreeNode createTree1() {
       TreeNode root = new TreeNode(3);
       root.left = new TreeNode(4);
       root.right = new TreeNode(5);
       root.left.left = new TreeNode(1);
       root.right.left = new TreeNode(2);
       
       return root;
    }
    
    public static TreeNode createTree2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        return root;
     }
    



  class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if (t == null && s == null) return true;
        if (t == null || s == null) return false;

        if (isSameTree(s, t)) return true;
        
        return isSubtree(s.left, t) || isSubtree(s.right,t);
        
    }
  }
  
  boolean isSameTree(TreeNode s, TreeNode t) {
  	if (t == null && s == null) return true;
    if (t == null || s == null) return false; 
	  
    if (t.val == s.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right))
    	return true;
    else
    	return false;  		
  }
  
}


  