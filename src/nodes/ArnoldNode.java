package nodes;

import implementation.Visitable;

/**
 * The Interface ArnoldNode.
 * 
 * @author Tudor Paraschivescu
 */
public interface ArnoldNode extends Visitable{

	/**
	 * Checks if a node is a leaf or not.
	 *
	 * @return True if the node is a leaf and false if it is not
	 */
	public boolean isLeaf();
	
	/**
	 * Change the parent of a node.
	 *
	 * @param parent The new parent of the node
	 */
	public void setParent (TreeNode parent);

}
