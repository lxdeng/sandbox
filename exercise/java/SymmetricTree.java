import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class SymmetricTree {
	public static void main(String[] args) {
		Solution sol = new SymmetricTree().new Solution();	
		
		TreeNode t = createTree();
		
		System.out.println(sol.isSymmetric(t));
	}
	
	static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		return root;
	}
	
	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        ArrayList<TreeNode> list = new ArrayList<>();
	        
	        queue.add(root);
	        
	        int count = 1;
	        while(!queue.isEmpty()) {
	            int nullCount = 0;
	            
	            for (int i = 0; i < count; i++) {
	                TreeNode node = queue.remove();
	                             
	                list.add(node);
	                
	                if (node != null) {
	                    queue.add(node.left);
	                    queue.add(node.right);
	                } else {
	                    ++nullCount;
	                    
	                    queue.add(null);
	                    queue.add(null);
	                }
	            }
	            
	            if (!checkSymmetric(list))
	                    return false;
	            
	            if (nullCount == count) return true;     
	                
	            list.clear();
	            
	            count *= 2;
	        }
	        
	        return true;
	            
	    }
	    
	    boolean checkSymmetric(ArrayList<TreeNode> list) {
	        for (int i = 0; i < list.size()/2; i++) {
	        	TreeNode x = list.get(i);
	        	TreeNode y = list.get(list.size()-1-i);
	        	
	        	if (x == null && y == null)
	        		continue;
	        	
	        	if (x == null || y == null)
	        		return false;
	        	
	            if (x.val != y.val)
	                return false;
	        }
	        
	        return true;
	    }
	}
}
