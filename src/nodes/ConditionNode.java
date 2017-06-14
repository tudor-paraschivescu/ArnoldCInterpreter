package nodes;

import implementation.Visitor;

/**
 * The Class ConditionNode.
 * 
 * @author Tudor Paraschivescu
 */
public class ConditionNode extends LeafNode {
	
	private String variableName;

	/**
	 * Instantiates a new condition node.
	 *
	 * @param parent the parent
	 * @param variable the variable
	 */
	public ConditionNode(TreeNode parent, String variable) {
		super(parent);
		this.variableName = variable;
	}
	
	/**
	 * Gets the variable name.
	 *
	 * @return the variable name
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * Sets the variable name.
	 *
	 * @param variableName the new variable name
	 */
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
