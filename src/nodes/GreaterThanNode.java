package nodes;

import implementation.Visitor;

/**
 * The Class GreaterThanNode.
 * 
 * @author Tudor Paraschivescu
 */
public class GreaterThanNode extends LogicalNode {

	/**
	 * Instantiates a new greater than node.
	 *
	 * @param parent the parent
	 */
	public GreaterThanNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
