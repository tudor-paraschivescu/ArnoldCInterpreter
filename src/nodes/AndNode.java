package nodes;

import implementation.Visitor;

/**
 * The Class AndNode.
 * 
 * @author Tudor Paraschivescu
 */
public class AndNode extends LogicalNode {

	/**
	 * Instantiates a new and node.
	 *
	 * @param parent the parent
	 */
	public AndNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
