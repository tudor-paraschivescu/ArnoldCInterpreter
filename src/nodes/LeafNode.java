package nodes;

/**
 * Abstract class that represents a leaf (tree node without subnodes).
 *
 * @author Tudor Paraschivescu
 */
public abstract class LeafNode implements ArnoldNode {
	
	private TreeNode parent;

	/**
	 * Instantiates a new leaf node.
	 *
	 * @param parent the parent
	 */
	public LeafNode(TreeNode parent) {
		this.parent = parent;
		if (parent != null) {
			parent.addSubNode(this);
		}
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
		this.parent.getSubNodes().remove(this);
		this.parent = parent;
		if (parent != null) {
			parent.addSubNode(this);
		}
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
	
}
