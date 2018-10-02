
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		
		Solution sol = new DiameterOfBinaryTree().new Solution();
		
		TreeNode t1 = createTree();
		
		//System.out.println(sol.height(t1));
		
		System.out.println(sol.diameterOfBinaryTree(t1));
		
		
	}
	
	static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}
		
	class Solution {
		    public int diameterOfBinaryTree(TreeNode root) {
		        if (root == null) return 0;
		        if (root.left == null && root.right == null) return 0;
		        
		        int max = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
		        
		        int path_with_root = height(root.left) + height(root.right);
		        
		        return Math.max(max, path_with_root);        
		    }
		    
		    int height(TreeNode root) {
		        if (root == null) return 0;
		        if (root.left == null && root.right == null) return 1;
		        
		        int h = Math.max(height(root.left), height(root.right)) + 1;
		        System.out.println(h);
		        return h;
		    }
		}
}
