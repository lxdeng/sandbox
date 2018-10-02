import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


public class Tree {
    public static void main(String[] args) {
    	/*
     Stack<TreeNode> s1 = new Stack<>();
     s1.push(null);
     System.out.println(s1.pop());*/
    	
     LinkedList<TreeNode> l1 = new LinkedList<>();
     l1.add(null);
     System.out.println(l1.remove());

      ArrayList<String> al = new ArrayList<String>();
      al.add("");
      
      Solution sol = new Solution();

      TreeNode t1 = createTree1();

      System.out.println(sol.getHeight(t1));
      //System.out.println(sol.getHeight_bft(t1));

      //sol.dft(t1);
      
      //sol.bft(t1);
      
      //System.out.println("recursive_dft:");
      //sol.recursive_dft(t1);
      
      List<List<String>> result = sol.printTree(t1);
      printList(result);
    }

    public static void printList(List<List<String>> list) {
      for(List<String> row : list) {
        for (String item: row) {
          System.out.print(item);
        }
        System.out.println();
      } 

    }

    public static TreeNode createTree1() {
       TreeNode root = new TreeNode(1);
       root.left = new TreeNode(2);
       root.right = new TreeNode(3);
       root.left.right = new TreeNode(4);
       return root;
    }
} 


class Solution {
  public List<List<String>> printTree(TreeNode root) {
    int height = getHeight(root);
    int cols = (int)Math.pow(2,height)-1;

    List<List<String>> list = initList(height, cols);
    //Tree.printList(list);

    print(root, list, 0, 0, cols); 

    return list;
  }

  public void print(TreeNode root, List<List<String>> list, int row, int colStart, int colEnd) {
    if (root == null) return;

    int mid = (colEnd - colStart)/2 + colStart;
    list.get(row).set(mid, "" + root.val);
    print(root.left, list, row + 1, colStart, mid - 1);
    print(root.right, list, row + 1, mid + 1, colEnd);  
  }

  public List<List<String>> initList(int rows, int cols) {
    List<List<String>> list = new ArrayList<List<String>>(rows);

    for (int i = 0; i < rows; i++) {
      List<String> row = new ArrayList<String>(cols);
      for (int j = 0; j < cols; j++)
        row.add("_");

      list.add(row);
    }

    return list;
  } 


  public int getHeight_bft(TreeNode root) {
   if (root == null) return 0;

   Queue<TreeNode> queue = new LinkedList<TreeNode>();
   queue.add(root);

   int height = 0;
   while(!queue.isEmpty()) {
     ++height;
     Queue<TreeNode> temp = new LinkedList<TreeNode>();
     
     while(!queue.isEmpty()) {
       TreeNode node = queue.remove();
       if (node.left != null)
          temp.add(node.left);
       if (node.right != null)
          temp.add(node.right);
     }

     queue = temp;
   }

   return height;
 }

 public int getHeight(TreeNode root) {
    if (root == null) return 0;
    
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
 }
 
 public void dft(TreeNode root) {
	 System.out.println("dft:");
	 Stack<TreeNode> stack = new Stack<TreeNode>();
	 if (root == null) 
		 return;
	 
	 stack.push(root);
	 
	 while(!stack.empty()) {
		 TreeNode node = stack.pop();
		 System.out.println(node.val);
		 
		 if (node.right != null)
				 stack.push(node.right);
		 if (node.left != null)
				 stack.push(node.left);
	 }	 	  
 }
 
 public void bft(TreeNode root) {
	 System.out.println("bft:");
	 Queue<TreeNode> queue = new LinkedList<TreeNode>();
	 
	 if (root == null)
		 return;
	 
	 queue.add(root);
	 
	 while(!queue.isEmpty()) {
		 TreeNode node = queue.remove();
		 System.out.println(node.val);
		 
		 if (node.left != null)
			 queue.add(node.left);
		 
		 if (node.right != null)
			 queue.add(node.right);	 
	 }
	 
 }
 
 public void recursive_dft(TreeNode root) {
	    
	    if (root == null) return;
	    
	    System.out.println(root.val);
	    recursive_dft(root.left);
	    recursive_dft(root.right);
	 }
 
}
