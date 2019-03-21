import java.util.*;

public class FindDupSubTree {
	

	public static void main(String args[]) {
		
		FindDupSubTree fbt = new FindDupSubTree();
		Solution sol = fbt.new Solution();
		TreeNode t1 = createTree2();
		List<TreeNode> r = sol.findDuplicateSubtrees(t1);
		
		System.out.println(r);
	}
	
	static TreeNode createTree() {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		
		t.left.left = new TreeNode(4);

		t.right.left = new TreeNode(2);
		t.right.right = new TreeNode(4);
		
		t.right.left.left = new TreeNode(4);

		
		return t;
		
	}
	
	static TreeNode createTree2() {
		TreeNode t = new TreeNode(0);
		t.left = new TreeNode(0);
		t.right = new TreeNode(0);
		
		t.left.left = new TreeNode(0);

		t.right.right = new TreeNode(0);
		
		t.left.left.left = new TreeNode(0);
		t.left.left.right = new TreeNode(0);
		//t.right.right.left = new TreeNode(0);
		//t.right.right.right = new TreeNode(0);
		
		return t;
		
	}
	
	class Solution {
	    HashSet<TreeNode> seen;
	    
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        ArrayList<TreeNode> list = new ArrayList<>();
	        seen = new HashSet<TreeNode>();
	        dfs(root, root, list);
	        return list;
	    }
	    
	    void dfs(TreeNode root, TreeNode r, List<TreeNode> list) {
	        if (root == null) return;
	        
	        if (root != r) {
	            check(root, r, list);
	        }
	        
	        dfs(root.left, r, list);
	        dfs(root.right, r, list);
	    }
	    
	    // for each node root, check whether r has a sub-tree same as root
	    void check(TreeNode root, TreeNode r, List<TreeNode> list) {
	        if (r == null) return;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(r);
	        
	        while(!queue.isEmpty()) {
	            TreeNode node = queue.remove();
	            //System.out.print(node.val + " ");
	            if (node.left != null) queue.add(node.left);
	            if (node.right != null) queue.add(node.right);
	            
	            //System.out.println("calling sameTree " + root.val + " " + node.val);
	            if (seen.contains(root) || seen.contains(node)) continue;
	            
	            if (sameTree(root, node)) {
	                list.add(root);
	                seen.add(root);
	                seen.add(node);
	            }    
	        }
	        //System.out.println();
	        
	    }
	    
	    boolean sameTree(TreeNode node1, TreeNode node2) {
	        //System.out.println(node1==null? "null" : node1.val);
	        //System.out.println(node2==null? "null" : node2.val + "\n");
	        
	        if (node1 == null && node2 == null) return true;
	        if (node1 == null || node2 == null) return false;
	        if (node1 == node2 || node1.val != node2.val) return false;
	        
	        return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
	    }
	    
	}

}
