package serializebst;

public class Codec {
	public static void main(String[] args) {
		
		
		TreeNode root = createTree1();
		
		Codec codec = new Codec();
		
		String s = codec.serialize(root);
		System.out.println(s);
		/*
		root = codec.deserialize(s);
		s = codec.serialize(root);
		System.out.println(s);
		System.out.println();
		*/
		
		root = createTree2();
		s = codec.serialize(root);
		System.out.println(s);
		
		root = codec.deserialize(s);
		s = codec.serialize(root);
		System.out.println(s);
		
		
		//root = codec.deserialize("");
	}
	
	static TreeNode createTree1() {
		TreeNode root = new TreeNode(1);
		return root;
	}
	
	static TreeNode createTree2() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		return root;
	}
	/*

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        String s = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new Data(data, 0));
    }
    
    private TreeNode deserialize(Data d) {
        TreeNode node;
        if (d.data[d.start] == '#') {
            node = null;
            d.start++;
            if (d.start != d.data.length)
            	++d.start; //skip comma
        } else {
            int end = d.start;
            while (d.data[end] >= '0' && d.data[end] <= '9') ++end;
            String temp = new String(d.data, d.start, end-d.start);
            node = new TreeNode(Integer.parseInt(temp));
            d.start = end + 1;
            node.left = deserialize(d);
            node.right = deserialize(d);
        }
        
        return node;
    }
  */
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if (root.left != null) {
            sb.append(',');
            sb.append(serialize(root.left));
        }
        
        if (root.right != null) {
            sb.append(',');
            sb.append(serialize(root.right));
        }
    
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data.length() == 0) return null;
        
        String arr[] = data.split(",");
        int[] d = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            d[i] = Integer.parseInt(arr[i]);

        return deserialize(d, 0, d.length);
    }
    
    // end is exclusive
    private TreeNode deserialize(int[] data, int start, int end) {
        if (start >= end) return null;
        
        TreeNode root = new TreeNode(data[start]);
        int i = start + 1;
        while (i < end && data[i] < data[start]) i++; // points to the right child
        
        root.left = deserialize(data, start+1, i);
        root.right = deserialize(data, i, end);
        return root;
    }
}

class Data {
	char[] data;
	int start;
	public Data(String d, int start) {
		data = d.toCharArray();
		this.start = start;
	}
}