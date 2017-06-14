package implementation;

import nodes.AndNode;
import nodes.ArnoldNode;
import nodes.AssignmentNode;
import nodes.ConditionNode;
import nodes.ConstantNode;
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
 * The Class PrintTreeVisitor
 * 
 * @author Tudor Paraschivescu
 */
public class PrintTreeVisitor implements Visitor {
	
	private String output;
	
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
		output = "MainNode\n";
	}

	@Override
	public void visit(PrintNode node) {
		output += "PrintNode\n";
	}
	
	@Override
	public void visit(ConstantNode node) {
		output += "ConstantNode <" + node.getValue() + ">\n";
	}

	@Override
	public void visit(StringNode node) {
		output += "StringNode <" + node.getText() + ">\n";
	}

	@Override
	public void visit(VariableNode node) {
		output += "VariableNode <" + node.getVariableName() + ">\n";
	}
	
	@Override
	public void visit(ConditionNode node) {
		output += "ConditionNode <" + node.getVariableName() + ">\n";
	}
	
	@Override
	public void visit(IfNode node) {
		output += "IfNode\n";
	}
	
	@Override
	public void visit(IfBodyNode node) {
		output += "IfBodyNode\n";
	}
	
	@Override
	public void visit(ElseBodyNode node) {
		output += "ElseBodyNode\n";
	}
	
	@Override
	public void visit(DeclareNode node) {
		output += "DeclareNode\n";
	}

	@Override
	public void visit(LValNode node) {
		output += "LvalNode <" + node.getVariableName() + ">\n";
	}

	@Override
	public void visit(WhileNode node) {
		output += "WhileNode\n";
	}
	
	@Override
	public void visit(WhileBodyNode node) {
		output += "BodyNode\n";
	}

	@Override
	public void visit(SumNode node) {
		output += "SumNode\n";
	}
	
	@Override
	public void visit(DifferenceNode node) {
		output += "DifferenceNode\n";
	}
	
	@Override
	public void visit(MultiplicationNode node) {
		output += "MultiplicationNode\n";
	}

	@Override
	public void visit(DivisionNode node) {
		output += "DivisionNode\n";
	}
	
	@Override
	public void visit(ModuloNode node) {
		output += "ModuloNode\n";
	}
	
	@Override
	public void visit(AndNode node) {
		output += "AndNode\n";
	}
	
	@Override
	public void visit(OrNode node) {
		output += "OrNode\n";
	}
	
	@Override
	public void visit(EqualToNode node) {
		output += "EqualToNode\n";
	}

	@Override
	public void visit(GreaterThanNode node) {
		output += "GreaterThanNode\n";
	}
	
	@Override
	public void visit(RValNode node) {
		output += "RvalNode <" + node.getVariableName() + ">\n";
	}
	
	@Override
	public void visit(AssignmentNode node) {
		output += "AssignmentNode\n";
	}

	/**
	 * Prints the Abstract Syntax Tree
	 *
	 * @param current the current node
	 * @param tabLevel the tab level of the current node
	 * @return the AST
	 */
	public String printAST(TreeNode current, int tabLevel) {
		
		visit(current);
		
		for (ArnoldNode n : current.getSubNodes()) {
			
			for (int i = 0; i < tabLevel; i++) {
				output += "\t";
			}
			
			if (n.isLeaf()) {
				visit((LeafNode)n);
			}
			else {
				printAST((TreeNode)n, tabLevel + 1);			
			}
		}
		return output;
	}

}
