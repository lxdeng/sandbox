package serializebinarytree;

import java.util.*;

public class Codec {
	public static void main(String[] args) {
		
		
		TreeNode root = createTree2();
		
		Codec codec = new Codec();
		
		String s = codec.serialize(root);
		System.out.println(s);
		
		root = codec.deserialize(s);
		s = codec.serialize(root);
		System.out.println(s);
		System.out.println();
		
		
	}
	
	static TreeNode createTree1() {
		TreeNode root = new TreeNode(1);
		return root;
	}
	
	static TreeNode createTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		return root;
	}
	
	
	/*
	
	NullNode nullNode = new NullNode();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (sb.length() > 0) sb.append(',');
            
            if (node == nullNode) {
                sb.append('#');
                continue;
            }
            
            sb.append(node.val);
            
            if (node.left == null)
                queue.add(nullNode);
            else
                queue.add(node.left);
            
            if (node.right == null)
                queue.add(nullNode);
            else
                queue.add(node.right);
        }
        
        while (sb.length() > 1 && 
               sb.charAt(sb.length()-1) == '#' && 
               sb.charAt(sb.length()-2) == ',') {
            sb.setLength(sb.length()-2);
        }
        
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '#')
            sb.setLength(sb.length()-1);
        
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        
        String d[] = data.split(",");
        ArrayList<TreeNode> current = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        current.add(root);
        
        int idx = 1;
        int nodesOfLevel = 1;
        while (current.size() > 0) {
            nodesOfLevel *= 2;
            ArrayList<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < nodesOfLevel; i++, idx++) {
                if (idx < d.length) {
                    if (d[idx].equals("#"))
                        next.add(nullNode);
                    else
                        next.add(new TreeNode(Integer.parseInt(d[idx])));
                } else
                    break;
            }

            setup(current, next);
            current = next;
        }
        
        return root;
    }
    
    void setup(ArrayList<TreeNode> current, ArrayList<TreeNode> next) {
        if (next.size() == 0) return;
        int idx = 0; // index of the next
        
        for (int i = 0; i < current.size(); i++) {
            TreeNode node = current.get(i);
            TreeNode ch;
            if (node == nullNode) {
                next.add(idx++, nullNode);
                next.add(idx++, nullNode);
                continue;
            }
            
            if (idx >= next.size()) 
                break;
            else {
                ch = next.get(idx++);
                if (ch != nullNode) node.left = ch;
            }
            
            if (idx >= next.size()) 
                break;
            else {
                ch = next.get(idx++);
                if (ch != nullNode) node.right = ch;
            }
        }
    }
}
*/
	
	public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

	public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
	
}

/*
class NullNode extends TreeNode {
    public NullNode() {
        super(0);
    }
}*/