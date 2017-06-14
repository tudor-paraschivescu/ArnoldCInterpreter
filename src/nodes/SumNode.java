package nodes;

import implementation.Visitor;

/**
 * The Class SumNode.
 * 
 * @author Tudor Paraschivescu
 */
public class SumNode extends ArithmeticNode {
	
	/**
	 * Instantiates a new sum node.
	 *
	 * @param parent the parent
	 */
	public SumNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
