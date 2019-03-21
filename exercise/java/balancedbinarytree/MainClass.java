package balancedbinarytree;

import java.io.*;
import java.util.*;

class Solution {

    public boolean isBalanced(TreeNode root) {
    	  	
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null)
            return true;
        
        if (root.left == null && root.right.left == null && root.right.right == null)
            return true;
        
        if (root.right == null && root.left.left == null && root.left.right == null)
            return true;
        
        if (isBalanced(root.left) && isBalanced(root.right)) {
            System.out.println("right height=" + height(root.right));
            int diff = height(root.left) - height(root.right);
            System.out.println("diff=" + diff);
            if (diff <=1 && diff >= -1)
                return true;
        }
            
        return false;
    }
    
    int height(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = "[1, null, 2, null, 3]";
        
        //while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            
            boolean ret = new Solution().isBalanced(root);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        //}
    }
}