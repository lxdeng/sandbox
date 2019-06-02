package smalleststringfromleaf;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = solution.createTree();
		System.out.println(solution.smallestFromLeaf(root));
	}
	
	
	 public TreeNode createTree() {
		 TreeNode root = new TreeNode(25);
		 root.left = new TreeNode(1);
		 root.left.left = new TreeNode(1);
		 root.left.right = new TreeNode(3);
		 
		 root.right = new TreeNode(3);
		 root.right.left = new TreeNode(0);
		 root.right.right = new TreeNode(2);
		 
		 return root;
	 }
	 
	 
	 String smallest = null;
	    
	 public String smallestFromLeaf(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        
	        if (root == null) return "";
	        
	        dfs(root, sb);
	        return smallest;
	 }
	    
	 void dfs(TreeNode root, StringBuilder sb) {
	        if (root == null) return;
	        
	        sb.append((char)(root.val + 'a'));
	        //s = (char)(root.val + 'a') + s;
	        
	        if (root.left == null && root.right == null) {
	            String s = new StringBuilder(sb).reverse().toString();
	            if (smallest == null)
	                smallest = s;
	            else {
	                if (s.compareTo(smallest) < 0)
	                    smallest = s;
	            }
	            //return;
	        }
	        
	        //sb.append((char)(root.val + 'a'));
	        dfs(root.left, sb);
	        dfs(root.right, sb);
	        
	        sb.deleteCharAt(sb.length()-1);
	}
}
