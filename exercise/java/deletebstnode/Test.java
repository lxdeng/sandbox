package deletebstnode;

public class Test {
	public static void main(String[] args) {
		
		//String s = "1,null,2";
		
		String s = "18,0,40,null,2,22,49,1,17,21,32,45,null,null,null,9,null,19,null,29,37,44,47,8,13,null,20,26,30,33,39,42,null,46,48,3,null,10,16,null,null,24,27,null,31,null,35,38,null,41,43,null,null,null,null,null,4,null,12,14,null,23,25,null,28,null,null,34,36,null,null,null,null,null,null,null,7,11,null,null,15,null,null,null,null,null,null,null,null,null,null,5,null,null,null,null,null,null,6";

		TreeNode t = createTree(s);
	
		
		Solution sol = new Solution();
		sol.printTreeToScreen(t);
		
		sol.deleteNode(t, 39);
		
	
	}
	
	static TreeNode createTree(String s) {
		String[] strNodes = s.split(",");
		
		/*
		for (String n : nodes) {
			System.out.println(n);
		}*/
		
		TreeNode[] nodes = new TreeNode[strNodes.length];
		//System.out.println("length=" + nodes.length);
		
		for (int i = 0; i < nodes.length; i++) {
			if (strNodes[i].equals("null"))
				nodes[i] = null;
			else {
				int n = Integer.valueOf(strNodes[i]);
				nodes[i] = new TreeNode(n);
			}
		}
		
		int i = 0;
		int exp = 1;
		while(true) {
			//if (i >= nodes.length)
			//	break;
			
			int j = i + exp;
			exp *= 2;
			
			if (j >= nodes.length)
				break;
			
			//System.out.println("i, j = " + i + " " + j);
			
			initNodes(nodes, i, j);
			
			i = j;
		}
	
		
		return nodes[0];
	}
	
	static void initNodes(TreeNode[] nodes, int i, int j) {
		//System.out.println(i);
		int m = j;
		for (int k = i; k < j; k++) {
			if (nodes[k] != null) {
				nodes[k].left = nodes[m++];
				nodes[k].right = nodes[m++];
			}
		}
	}
	
}
