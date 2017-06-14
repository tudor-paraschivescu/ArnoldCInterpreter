package nodes;

import implementation.Visitor;

/**
 * The Class ModuloNode.
 * 
 * @author Tudor Paraschivescu
 */
public class ModuloNode extends ArithmeticNode {

	/**
	 * Instantiates a new modulo node.
	 *
	 * @param parent the parent
	 */
	public ModuloNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
