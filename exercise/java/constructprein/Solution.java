package constructprein;

import java .util.*;

class Solution {
	
	public static void main(String[] args) {
		//int pre[] = {1,2,4,5,3,6,7};
		//int post[] = {4,5,2,6,7,3,1};
		
		//int pre[] = {2,1};
		//int post[] = {1,2};
		
		int[] pre = {1,2,3};
		int[] inorder = {2,3,1};
		Solution sol = new Solution();
		TreeNode tree = sol.buildTree(pre, inorder);
		System.out.println(tree.val);
		
	}
	
	HashMap<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        System.out.println("pStart=" + pStart +", pEnd=" + pEnd);
        
        if (pStart > pEnd) return null;
        if (pStart == pEnd) return new TreeNode(preorder[pStart]);
        
        TreeNode root = new TreeNode(preorder[pStart]);
        
        int rootIndex = inorderMap.get(preorder[pStart]);
        int leftNodes = rootIndex - iStart;
        
        TreeNode left = build(preorder, pStart + 1, pStart + leftNodes, inorder, iStart, iStart + leftNodes - 1);
        TreeNode right = build(preorder, pStart + leftNodes + 1, pEnd, inorder, iStart + leftNodes + 1, iEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}