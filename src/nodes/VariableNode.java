package nodes;

import java.util.HashMap;

import implementation.Visitor;

/**
 * The Class VariableNode.
 * 
 * @author Tudor Paraschivescu
 */
public class VariableNode extends LeafNode implements DataNode {
	
	private String variableName;

	/**
	 * Instantiates a new variable node.
	 *
	 * @param parent the parent
	 * @param variableName the variable name
	 */
	public VariableNode(TreeNode parent, String variableName) {
		super(parent);
		this.variableName = variableName;
	}
	
	/**
	 * Gets the variable name.
	 *
	 * @return the variable name
	 */
	public String getVariableName() {
		return this.variableName;
	}
	
	/**
	 * Sets the variable name.
	 *
	 * @param name the new variable name
	 */
	public void setVariableName(String name) {
		this.variableName = name;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int getValue(HashMap<String, Integer> map) {
		return map.get(variableName);
	}

}
