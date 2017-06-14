package nodes;

import implementation.Visitor;

/**
 * The Class IfBodyNode.
 * 
 * @author Tudor Paraschivescu
 */
public class IfBodyNode extends TreeNode {

	/**
	 * Instantiates a new if body node.
	 *
	 * @param parent the parent
	 */
	public IfBodyNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
