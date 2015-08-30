package data.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode<Content> {
	private List<TreeNode> nodes = new LinkedList<TreeNode>();
	private Content content = null;
	
	public TreeNode(Content content) {
		this.content = content;
	}
	
	public void appendNode(TreeNode t){
		nodes.add(t);
	}
	
//	public void 
}