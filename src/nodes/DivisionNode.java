package nodes;

import implementation.Visitor;

/**
 * The Class DivisionNode.
 * 
 * @author Tudor Paraschivescu
 */
public class DivisionNode extends ArithmeticNode {

	/**
	 * Instantiates a new division node.
	 *
	 * @param parent the parent
	 */
	public DivisionNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
