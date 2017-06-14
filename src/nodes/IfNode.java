package nodes;

import implementation.Visitor;

/**
 * The Class IfNode.
 * 
 * @author Tudor Paraschivescu
 */
public class IfNode extends TreeNode {
	
	/**
	 * Instantiates a new if node.
	 *
	 * @param parent the parent
	 * @param variable the variable
	 */
	public IfNode(TreeNode parent, String variable) {
		super(parent);
		new ConditionNode(this, variable);
		new IfBodyNode(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
