package nodes;

import implementation.Visitor;

/**
 * The Class AssignmentNode.
 * 
 * @author Tudor Paraschivescu
 */
public class AssignmentNode extends TreeNode {

	/**
	 * Instantiates a new assignment node.
	 *
	 * @param parent the parent
	 * @param variableName the variable name
	 */
	public AssignmentNode(TreeNode parent, String variableName) {
		super(parent);
		new LValNode(this, variableName);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
