package deletebstnode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    TreeNode parent;
    TreeNode nodeFound;
       
    public TreeNode deleteNode(TreeNode root, int key) {
        searchNode(root, key);
        
        if (nodeFound == null) // not found
            return root;
        
        if (nodeFound.right == null) {
            if (parent == null)
                return nodeFound.left;
            else {
                if (parent.left == nodeFound)
                    parent.left = nodeFound.left;
                else
                    parent.right = nodeFound.right;
                return root;     
            }
        }
        
        
        TreeNode t = adjust(nodeFound.right);
        t.left = nodeFound.left;
        if (parent == null) {
            return t;
        } else {
            if (parent.left == nodeFound)
                parent.left = t;
            else
                parent.right = t;
            return root;
        }  
    }
    
    TreeNode adjust(TreeNode root) {
        TreeNode t = root;
        TreeNode p = null;
        while(t != null && t.left != null) {
            p = t;
            t = t.left;
        }
        
        if (t != root) {
            p.left = t.right;
            t.right = root;
        }
        
        return t;
    }
    
    void searchNode(TreeNode root, int key) {
        if (root == null)
            return;
        
        if (root.val == key) {
            nodeFound = root;
            return;
        }
        
        parent = root;
        
        if (key <= root.val)
            searchNode(root.left, key);
        else
            searchNode(root.right, key);        
    }
    
    public void printTreeToScreen(TreeNode root) {
    	List<List<String>> list = printTree(root);
    	
    	for (List<String> row : list) {
    		for (String s: row) {
    			System.out.print(s+" ");
    		}
    		System.out.println();
    	}
    }
    
    
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr,"");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
