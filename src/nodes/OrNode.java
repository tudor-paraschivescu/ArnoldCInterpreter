package nodes;

import implementation.Visitor;

/**
 * The Class OrNode.
 * 
 * @author Tudor Paraschivescu
 */
public class OrNode extends LogicalNode {

	/**
	 * Instantiates a new or node.
	 *
	 * @param parent the parent
	 */
	public OrNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
