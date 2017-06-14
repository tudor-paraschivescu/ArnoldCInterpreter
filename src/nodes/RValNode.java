package nodes;

import implementation.Visitor;

/**
 * The Class RValNode.
 * 
 * @author Tudor Paraschivescu
 */
public class RValNode extends VariableNode {

	/**
	 * Instantiates a new right value node.
	 *
	 * @param parent the parent
	 * @param variableName the variable name
	 */
	public RValNode(TreeNode parent, String variableName) {
		super(parent, variableName);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
