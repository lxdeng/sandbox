package constructtreeprepost;

class Solution {
	
	public static void main(String[] args) {
		//int pre[] = {1,2,4,5,3,6,7};
		//int post[] = {4,5,2,6,7,3,1};
		
		//int pre[] = {2,1};
		//int post[] = {1,2};
		
		int[] pre = {1,2,4,3,6,5};
		int[] post = {3,5,6,4,2,1};
		Solution sol = new Solution();
		TreeNode tree = sol.constructFromPrePost(pre, post);
		System.out.println(tree.val);
		
	}
	
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length-1, post, 0, post.length-1);
    }
    
    TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(pre[preStart]);
        
        TreeNode root = new TreeNode(pre[preStart]);
        
        int leftNodes = index(post, postStart, pre[preStart+1]) - postStart + 1;
        TreeNode left = construct(pre, preStart+1, preStart + leftNodes, post, postStart, postStart + leftNodes - 1);
        TreeNode right = construct(pre, preStart + leftNodes + 1, preEnd, post, postStart + leftNodes, postEnd - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    
    int index(int[] a, int start, int v) {
        int index = -1;
        for (int i = start; i < a.length; i++)
            if (a[i] == v) {
                index = i;
                break;
            }
        return index;
    }
}