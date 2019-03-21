package treelinknode;

//import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		TreeLinkNode root = createTree2();
		Solution sol = new Solution();
		sol.connect(root);
	}
	
	static TreeLinkNode createTree() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);
		root.left.left.left = new TreeLinkNode(7);
		root.right.right.right = new TreeLinkNode(8);
		return root;
	}
	
	static TreeLinkNode createTree2() {
		TreeLinkNode root = new TreeLinkNode(3);
		root.left = new TreeLinkNode(9);
		/*
		root.right = new TreeLinkNode(20);
		
		root.right.left = new TreeLinkNode(15);
		root.right.right = new TreeLinkNode(7);
		*/
		return root;
	}
	
	public void connect(TreeLinkNode root) {
		/*
	    for (TreeLinkNode dummyHead = new TreeLinkNode(0); root != null; root = dummyHead.next, dummyHead.next = null)
	    {
	        for (TreeLinkNode level = root, last = dummyHead; level != null; level = level.next)
	        {
	            if (level.left != null)
	            {
	                last.next = level.left;
	                last = last.next;
	            }

	            if (level.right != null)
	            {
	                last.next = level.right;
	                last = last.next;
	            }
	        }
	    }*/
		
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		
		// level traverse from left to right on a level
		// dummy head's next points to first node of the level
		
		while (root != null) {
			TreeLinkNode level = root;
			TreeLinkNode last = dummyHead;
			
			while(level != null) {
				 if (level.left != null) {
					 last.next = level.left;
		             last = last.next;
		          }

		          if (level.right != null) {
		                last.next = level.right;
		                last = last.next;
		          }
				  level = level.next;
			}
			root = dummyHead.next;
			//dummyHead.next = null; // reset the next
		}
	
	}
}
	
	/*
	    public void connect(TreeLinkNode root) {
	        
	        while (root != null) {
	            TreeLinkNode firstRoot = root;
	            
	            while (root != null) {
	                if (root.left != null && root.right != null)
	                    root.left.next = root.right;
	                
	                TreeLinkNode target = getNext(root.next);
	                if (target != null) {
	                	TreeLinkNode targetChild = target.left != null? target.left : target.right;
	                    if (root.right != null)
	                        root.right.next = targetChild;
	                    else if (root.left != null)
	                            root.left.next = targetChild;
	                }
	                root = target;
	            }
	            root = getNext(firstRoot);
	            if (root == null) break;
	            if (root.left != null)
	                root = root.left;
	            else
	                root = root.right;
	        }
	    }
	    
	    TreeLinkNode getNext(TreeLinkNode root) {
	        while (root != null) {
	            if ((root.left != null || root.right != null))
	                return root;
	            root = root.next;
	        }
	        return null;
	    }
	        
	}
	
	*/
        