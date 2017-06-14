package nodes;

import implementation.Visitor;

/**
 * The Class DifferenceNode.
 * 
 * @author Tudor Paraschivescu
 */
public class DifferenceNode extends ArithmeticNode {

	/**
	 * Instantiates a new difference node.
	 *
	 * @param parent the parent
	 */
	public DifferenceNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
