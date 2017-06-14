package nodes;

import java.util.HashMap;

import implementation.Visitor;

/**
 * The Class ConstantNode.
 * 
 * @author Tudor Paraschivescu
 */
public class ConstantNode extends LeafNode implements DataNode {
	
	private int value;
	
	/**
	 * Instantiates a new constant node.
	 *
	 * @param parent the parent
	 * @param value the value
	 */
	public ConstantNode(TreeNode parent, int value) {
		super(parent);
		this.value = value;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public int getValue(HashMap<String, Integer> map) {
		return getValue();
	}

}
