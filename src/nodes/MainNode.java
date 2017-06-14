package nodes;

import implementation.Visitor;

/**
 * The Class MainNode.
 * 
 * @author Tudor Paraschivescu
 */
public class MainNode extends TreeNode {
	
	/**
	 * Instantiates a new main node.
	 *
	 * @param parent the parent
	 */
	public MainNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
