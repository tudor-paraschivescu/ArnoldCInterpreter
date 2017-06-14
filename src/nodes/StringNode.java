package nodes;

import implementation.Visitor;

/**
 * The Class StringNode.
 * 
 * @author Tudor Paraschivescu
 */
public class StringNode extends LeafNode {

	/** The text. */
	private String text;
	
	/**
	 * Instantiates a new string node.
	 *
	 * @param parent the parent
	 * @param text the text
	 */
	public StringNode(TreeNode parent, String text) {
		super(parent);
		this.text = text;
	}
	
	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
