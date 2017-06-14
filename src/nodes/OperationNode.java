package nodes;

/**
 * The abstract Class OperationNode.
 * 
 * @author Tudor Paraschivescu
 */
public abstract class OperationNode extends TreeNode {

	/**
	 * Instantiates a new operation node.
	 *
	 * @param parent the parent
	 */
	public OperationNode(TreeNode parent) {
		super(parent);
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public ArnoldNode getLeft() {
		return this.getSubNodes().get(0);
	}
	
	/**
	 * Gets the right.
	 *
	 * @return the right
	 */
	public ArnoldNode getRight() {
		return this.getSubNodes().get(1);
	}

}
