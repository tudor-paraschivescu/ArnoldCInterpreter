package nodes;

import implementation.Visitor;

/**
 * The Class LValNode.
 * 
 * @author Tudor Paraschivescu
 */
public class LValNode extends VariableNode {

	/**
	 * Instantiates a new left value node.
	 *
	 * @param parent the parent
	 * @param variableName the variable name
	 */
	public LValNode(TreeNode parent, String variableName) {
		super(parent, variableName);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}