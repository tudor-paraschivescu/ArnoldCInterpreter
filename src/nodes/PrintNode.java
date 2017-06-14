package nodes;

import implementation.Visitor;

/**
 * The Class PrintNode.
 * 
 * @author Tudor Paraschivescu
 */
public class PrintNode extends TreeNode {
	
	/**
	 * Instantiates a new print node.
	 *
	 * @param parent the parent
	 */
	public PrintNode(TreeNode parent) {
		super(parent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}
