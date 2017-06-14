package nodes;

import java.util.ArrayList;

/**
 * Abstract class that represents a tree node with subnodes.
 *
 * @author Tudor Paraschivescu
 */
public abstract class TreeNode implements ArnoldNode {
	
	private TreeNode parent;
	
	private ArrayList<ArnoldNode> subNodes;

	/**
	 * Instantiates a new tree node.
	 *
	 * @param parent the parent
	 */
	public TreeNode(TreeNode parent) {
		this.parent = parent;
		if (parent != null) {
			parent.addSubNode(this);
		}
		subNodes = new ArrayList<ArnoldNode>();
	}
	
	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}
	
	@Override
	public void setParent (TreeNode parent) {
		this.parent = parent;
		if (parent != null) {
			parent.addSubNode(this);
		}
	}
	
	/**
	 * Adds a sub node.
	 *
	 * @param node the node
	 */
	public void addSubNode(ArnoldNode node) {
		subNodes.add(node);
	}
	
	/**
	 * Gets the sub nodes.
	 *
	 * @return the sub nodes
	 */
	public ArrayList<ArnoldNode> getSubNodes() {
		return this.subNodes;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
}
