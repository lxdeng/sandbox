package recovertreefrompreorder;

import java.util.regex.*;

public class Solution {
	
	public static void main(String[] args) {
		
		//Pattern p = Pattern.compile("[]-[0-9]+");
		
		String s = "1-2--3--4-5--6--7";
		
		TreeNode root = new Solution().recoverFromPreorder(s);
	}
	
	int index = 0;
    public TreeNode recoverFromPreorder(String S) {
        return helper(S, 0);
    }
    
    public TreeNode helper(String s, int depth) {
        int numDash = 0;
        while (index + numDash < s.length() && s.charAt(index + numDash) == '-') {
            numDash++;
        }
        if (numDash != depth) return null;
        int next = index + numDash;
        while (next < s.length() && s.charAt(next) != '-') next++;
        int val = Integer.parseInt(s.substring(index + numDash, next));
        index = next;
        TreeNode root = new TreeNode(val);
        root.left = helper(s, depth + 1);
        root.right = helper(s, depth + 1);
        return root;
    }
}
