package nodes;

import implementation.Visitor;

/**
 * The Class MultiplicationNode.
 * 
 * @author Tudor Paraschivescu
 */
public class MultiplicationNode extends ArithmeticNode {

	/**
	 * Instantiates a new multiplication node.
	 *
	 * @param parent the parent
	 */
	public MultiplicationNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
