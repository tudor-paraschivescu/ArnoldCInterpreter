package nodes;

import implementation.Visitor;

/**
 * The Class WhileNode.
 * 
 * @author Tudor Paraschivescu
 */
public class WhileNode extends TreeNode {

	/**
	 * Instantiates a new while node.
	 *
	 * @param parent the parent
	 * @param condition the condition
	 */
	public WhileNode(TreeNode parent, String condition) {
		super(parent);
		new ConditionNode(this, condition);
		new WhileBodyNode(this);
	}
	
	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public ConditionNode getCondition() {
		return (ConditionNode)this.getSubNodes().get(0);
	}
	
	/**
	 * Gets the body.
	 *
	 * @return the body
	 */
	public WhileBodyNode getBody() {
		return (WhileBodyNode)this.getSubNodes().get(1);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
