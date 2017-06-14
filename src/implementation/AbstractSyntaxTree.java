package implementation;
import java.io.File;
import java.util.ArrayList;

import nodes.MainNode;
import nodes.TreeNode;

/**
 * The Class AbstractSyntaxTree.
 * 
 * @author Tudor Paraschivescu
 */
public class AbstractSyntaxTree {
	
	private TreeNode mainNode;
	
	/**
	 * Instantiates a new abstract syntax tree.
	 */
	public AbstractSyntaxTree() {
		mainNode = new MainNode(null);
	}
	
	/**
	 * Instantiates a new abstract syntax tree.
	 *
	 * @param inputFile the input file
	 */
	public AbstractSyntaxTree(File inputFile) {
		
		this();
		
		// The current node
		TreeNode currentNode = mainNode;

		// Get the relevant lines from the file and the code of each command
		ArrayList<StringWithIntCode> inputLines =
								ArnoldCFileParser.readFrom(inputFile);
		
		// Create a node factory
		NodeFactory nodeFactory = new NodeFactory();
		
		for (StringWithIntCode s : inputLines) {
			
			// Create the new nodes that must be added in the AST
			TreeNode aux = nodeFactory.createNode(
							s.getIntCode(), currentNode, s.getText());
			
			// Change the current node (if it is the case)
			if (aux != null) {
				currentNode = aux;
			}
		}
	}
	
	/**
	 * Gets the main node.
	 *
	 * @return the main node
	 */
	public TreeNode getMainNode() {
		return mainNode;
	}
	
}
