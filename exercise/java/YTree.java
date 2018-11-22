import java.util.List;
import java.util.ArrayList;

public class YTree {
	public static void main(String args[]) {
		YTree t = new YTree();
		
		t.applyStringProperty("a.b.c=1");
		t.applyStringProperty("a.b.d=1");
		t.applyStringProperty("aa.b.d=1");
		System.out.println(t.generateYAML());
	}
	
	private YTreeNode dummyRoot;
	
	public YTree() {
		 dummyRoot = new YTreeNode(null);
	}
	
	public void applyStringProperty(String s) {
		String[] props = s.split("\\.");
		
		YTreeNode current = dummyRoot;
		for (int i = 0; i < props.length - 1; i++) {
			current = current.searchOrAdd(props[i]);
		}
		
		String[] last = props[props.length - 1].split("=");
		current = current.searchOrAdd(last[0]);
		current.addLeafNode(last[1]);
	}
	
	
	public String generateYAML() {
		StringBuilder sb = new StringBuilder();
		
		if (dummyRoot.children != null) {
			for (YTreeNode node : dummyRoot.children)
				dfs(sb, node, "");
		}
		
		return sb.toString();
	}
	
	void dfs(StringBuilder sb, YTreeNode root, String indent) {
		root.printYAML(sb, indent);
		
		if (root.children != null) {
			for (YTreeNode node : root.children)
				dfs(sb, node, indent + "  ");
		}
	}
}

class YTreeNode {
	String val;
	List<YTreeNode> children;
	
	YTreeNode(String val) {
		this.val = val;
	}
	
	// 
	YTreeNode searchOrAdd(String p) {
		if (children != null) {	
		  for (YTreeNode node : children) {
			if (node.val.equals(p)) {
				return node;
			}
		  }
		} else {
	    	children = new ArrayList<YTreeNode>();
		}
		
		YTreeNode node = new YTreeNode(p);
		children.add(node);
		return node;
	}
	
	void addLeafNode(String v) {
		if (children == null)
			children = new ArrayList<YTreeNode>();
		else
			children.clear();
		
		children.add(new YLeafTreeNode(v));
	}
	
	void printYAML(StringBuilder sb, String indent) {
		if (val != null)
			sb.append(indent + val + ":\n");
	}
	
}

class YLeafTreeNode extends YTreeNode {
	YLeafTreeNode(String val) {
		super(val);
	}
	
	void printYAML(StringBuilder sb, String indent) {
		sb.append(indent + val + "\n");
	}
}