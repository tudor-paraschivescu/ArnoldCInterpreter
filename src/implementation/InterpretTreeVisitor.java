package implementation;

import java.util.HashMap;

import nodes.AndNode;
import nodes.ArnoldNode;
import nodes.AssignmentNode;
import nodes.ConditionNode;
import nodes.ConstantNode;
import nodes.DataNode;
import nodes.DeclareNode;
import nodes.DifferenceNode;
import nodes.DivisionNode;
import nodes.ElseBodyNode;
import nodes.EqualToNode;
import nodes.GreaterThanNode;
import nodes.IfBodyNode;
import nodes.IfNode;
import nodes.LValNode;
import nodes.LeafNode;
import nodes.MainNode;
import nodes.ModuloNode;
import nodes.MultiplicationNode;
import nodes.OperationNode;
import nodes.OrNode;
import nodes.PrintNode;
import nodes.RValNode;
import nodes.StringNode;
import nodes.SumNode;
import nodes.TreeNode;
import nodes.VariableNode;
import nodes.WhileBodyNode;
import nodes.WhileNode;

/**
 * The Class InterpretTreeVisitor.
 * 
 * @author Tudor Paraschivescu
 */
public class InterpretTreeVisitor implements Visitor {

	/** The variables. */
	HashMap<String, Integer> variables;
	
	private String output = "";

	/**
	 * Instantiates a new interpret tree visitor.
	 */
	public InterpretTreeVisitor() {
		variables = new HashMap<String, Integer>();
	}

	@Override
	public void visit(ArnoldNode node) {
		node.accept(this);
	}

	@Override
	public void visit(TreeNode node) {
		node.accept(this);
	}

	@Override
	public void visit(LeafNode node) {
		node.accept(this);
	}

	@Override
	public void visit(MainNode node) {
		// Nothing happens
	}

	@Override
	public void visit(PrintNode node) {
		// visit the node that must be printed
		LeafNode printIt = (LeafNode) node.getSubNodes().get(0);
		visit(printIt);
	}

	@Override
	public void visit(ConstantNode node) {
		output += node.getValue() + "\n";
	}

	@Override
	public void visit(VariableNode node) {
		String varName = node.getVariableName();
		Integer value = variables.get(varName);

		if (value != null) {
			output += value.toString() + "\n";
		}
	}

	@Override
	public void visit(StringNode node) {
		output += node.getText() + "\n";
	}

	@Override
	public void visit(ConditionNode node) {
		// Nothing happens
	}

	@Override
	public void visit(IfNode node) {
		
		// Get the condition
		ConditionNode condition = (ConditionNode) node.getSubNodes().get(0);
		
		// Get the value of the condition
		Integer value = variables.get(condition.getVariableName());

		if (value != 0) {
			// Go to if body
			visit((TreeNode) node.getSubNodes().get(1));
		} else {
			// Go to else body (if it exists)
			if (node.getSubNodes().size() > 2) {
				visit((TreeNode) node.getSubNodes().get(2));
			}
		}
	}

	@Override
	public void visit(IfBodyNode node) {
		for (ArnoldNode n : node.getSubNodes()) {
			// Visit all sub nodes
			visit((TreeNode) n);
		}
	}

	@Override
	public void visit(ElseBodyNode node) {
		for (ArnoldNode n : node.getSubNodes()) {
			// Visit all sub nodes
			visit((TreeNode) n);
		}
	}

	@Override
	public void visit(DeclareNode node) {

		// Get the name and the value of the new variable
		String variableName = node.getLValNode().getVariableName();
		Integer value = node.getConstant().getValue();

		// Add the new variable in the variables map
		variables.put(variableName, value);
	}

	@Override
	public void visit(LValNode node) {
		// Nothing happens
	}

	@Override
	public void visit(RValNode node) {
		// Nothing happens
	}

	@Override
	public void visit(WhileNode node) {

		// Get the condition
		String conditionName = node.getCondition().getVariableName();
		
		// Get the value of the condition
		int value = variables.get(conditionName);

		// Loop until value reaches 0
		while (value != 0) {
			
			visit(node.getBody());
			
			// Change the value of the condition in the hash map
			value = variables.get(conditionName);
		}
	}

	@Override
	public void visit(WhileBodyNode node) {
		for (ArnoldNode n : node.getSubNodes()) {
			// Visit all sub nodes
			visit((TreeNode) n);
		}
	}

	private int getLValue(OperationNode node) {
		
		ArnoldNode left = node.getLeft();
		int leftVal;
		
		if (left.isLeaf()) {
			leftVal = ((DataNode)left).getValue(variables);
		}
		else {
			visit(left);
			// The result of the operation will be at the null key
			leftVal = variables.get(null);
		}
		
		return leftVal;
	}
	
	private int getRValue(OperationNode node) {
		ArnoldNode right = node.getRight();
		return ((DataNode)right).getValue(variables);
	}

	@Override
	public void visit(SumNode node) {
		variables.put(null, getLValue(node) + getRValue(node));
	}
	
	@Override
	public void visit(DifferenceNode node) {
		variables.put(null, getLValue(node) - getRValue(node));
	}
	
	@Override
	public void visit(MultiplicationNode node) {
		variables.put(null, getLValue(node) * getRValue(node));
	}

	@Override
	public void visit(DivisionNode node) {
		variables.put(null, getLValue(node) / getRValue(node));
	}

	@Override
	public void visit(ModuloNode node) {
		variables.put(null, getLValue(node) % getRValue(node));
	}
	
	@Override
	public void visit(AndNode node) {
		int lVal = getLValue(node);
		int rVal = getRValue(node);
		
		if ((lVal != 0) && (rVal != 0)) {
			variables.put(null, 1);
		}
		else {
			variables.put(null, 0);
		}
	}
	
	@Override
	public void visit(OrNode node) {
		int lVal = getLValue(node);
		int rVal = getRValue(node);
		
		if ((lVal != 0) || (rVal != 0)) {
			variables.put(null, 1);
		}
		else {
			variables.put(null, 0);
		}
	}
	
	@Override
	public void visit(EqualToNode node) {
		if (getLValue(node) == getRValue(node)) {
			variables.put(null, 1);
		}
		else {
			variables.put(null, 0);
		}
	}
	
	@Override
	public void visit(GreaterThanNode node) {
		if (getLValue(node) > getRValue(node)) {
			variables.put(null, 1);
		}
		else {
			variables.put(null, 0);
		}
	}
	
	@Override
	public void visit(AssignmentNode node) {
		
		// Get the name of the LValNode
		String lValName = ((LValNode) node.getSubNodes().get(0)).
											getVariableName();
		
		// Get the right node
		ArnoldNode rightNode = node.getSubNodes().get(1);
		
		int rValue;
		
		if (rightNode.isLeaf()) {
			rValue = ((DataNode)rightNode).getValue(variables);
		}
		else {
			visit(rightNode);
			// Put the value of RNode at the null key in the hash map
			rValue = variables.get(null);
		}
		
		// Put the new value in the hash map
		variables.put(lValName, rValue);
	}
	
	
	/**
	 * Interpret the Abstract Syntax Tree
	 *
	 * @param start the starting node
	 * @return The output of the ArnoldC program
	 */
	public String interpretAST(TreeNode start) {

		for (ArnoldNode n : start.getSubNodes()) {
			visit((TreeNode) n);
		}
		
		return output;
	}

}
