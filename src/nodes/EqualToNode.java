package nodes;

import implementation.Visitor;

/**
 * The Class EqualToNode.
 * 
 * @author Tudor Paraschivescu
 */
public class EqualToNode extends LogicalNode {

	/**
	 * Instantiates a new equal to node.
	 *
	 * @param parent the parent
	 */
	public EqualToNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
