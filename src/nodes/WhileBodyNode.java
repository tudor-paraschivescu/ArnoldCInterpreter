package nodes;

import implementation.Visitor;

/**
 * The Class WhileBodyNode.
 * 
 * @author Tudor Paraschivescu
 */
public class WhileBodyNode extends TreeNode {

	/**
	 * Instantiates a new while body node.
	 *
	 * @param parent the parent
	 */
	public WhileBodyNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
