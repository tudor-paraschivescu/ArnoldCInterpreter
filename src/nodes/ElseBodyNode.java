package nodes;

import implementation.Visitor;

/**
 * The Class ElseBodyNode.
 * 
 * @author Tudor Paraschivescu
 */
public class ElseBodyNode extends TreeNode {

	/**
	 * Instantiates a new else body node.
	 *
	 * @param parent the parent
	 */
	public ElseBodyNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
