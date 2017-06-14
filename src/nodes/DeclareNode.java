package nodes;

import implementation.Visitor;

/**
 * The Class DeclareNode.
 * 
 * @author Tudor Paraschivescu
 */
public class DeclareNode extends TreeNode {

	/**
	 * Instantiates a new declare node.
	 *
	 * @param parent the parent
	 */
	public DeclareNode(TreeNode parent) {
		super(parent);
	}
	
	/**
	 * Gets the left value node.
	 *
	 * @return the left value node
	 */
	public LValNode getLValNode() {
		return (LValNode)(this.getSubNodes().get(0));
	}
	
	/**
	 * Gets the constant.
	 *
	 * @return the constant
	 */
	public ConstantNode getConstant() {
		return (ConstantNode)(this.getSubNodes().get(1));
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
