package longestunivaluepath;

public class Test {
	public static void main(String args[]) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		
		Solution sol = new Solution();

		System.out.println(sol.longestUnivaluePath(root));
	}

}
