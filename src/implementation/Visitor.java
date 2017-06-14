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
 * Interface of a Visitor that respects the associated design pattern.
 *
 * @author Tudor Paraschivescu
 */
public interface Visitor {
	
	/**
	 * Visit an Arnold Node
	 *
	 * @param node the Arnold node
	 */
	public void visit(ArnoldNode node);
	
	/**
	 * Visit a tree node
	 *
	 * @param node the tree node
	 */
	public void visit(TreeNode node);
	
	/**
	 * Visit a leaf node
	 *
	 * @param node the leaf node
	 */
	public void visit(LeafNode node);
	
	/**
	 * Visit a main node
	 *
	 * @param node the main node
	 */
	public void visit(MainNode node);

	/**
	 * Visit a print node
	 *
	 * @param node the print node
	 */
	public void visit(PrintNode node);
	
	/**
	 * Visit a constant node
	 *
	 * @param node the constant node
	 */
	public void visit(ConstantNode node);
	
	/**
	 * Visit a variable node
	 *
	 * @param node the variable node
	 */
	public void visit(VariableNode node);
	
	/**
	 * Visit a string node
	 *
	 * @param node the string node
	 */
	public void visit(StringNode node);
	
	/**
	 * Visit a condition node
	 *
	 * @param node the condition node
	 */
	public void visit(ConditionNode node);
	
	/**
	 * Visit a if node
	 *
	 * @param node the if node
	 */
	public void visit(IfNode node);
	
	/**
	 * Visit an if body node
	 *
	 * @param node the if body node
	 */
	public void visit(IfBodyNode node);
	
	/**
	 * Visit an else body node
	 *
	 * @param node the else body node
	 */
	public void visit(ElseBodyNode node);
	
	/**
	 * Visit a declare node
	 *
	 * @param node the declare node
	 */
	public void visit(DeclareNode node);
	
	/**
	 * Visit a left value node
	 *
	 * @param node the left value node
	 */
	public void visit(LValNode node);
	
	/**
	 * Visit a right value node
	 *
	 * @param node the right value node
	 */
	public void visit(RValNode node);
	
	/**
	 * Visit a while node
	 *
	 * @param node the while node
	 */
	public void visit(WhileNode node);

	/**
	 * Visit a while body node
	 *
	 * @param node the while body node
	 */
	public void visit(WhileBodyNode node);
	
	/**
	 * Visit an assignment node
	 *
	 * @param node the assignment node
	 */
	public void visit(AssignmentNode node);
	
	/**
	 * Visit a sum node
	 *
	 * @param node the sum node
	 */
	public void visit(SumNode node);
	
	/**
	 * Visit a difference node
	 *
	 * @param node the difference node
	 */
	public void visit(DifferenceNode node);
	
	/**
	 * Visit a multiplication node
	 *
	 * @param node the multiplication node
	 */
	public void visit(MultiplicationNode node);
	
	/**
	 * Visit a division node
	 *
	 * @param node the division node
	 */
	public void visit(DivisionNode node);
	
	/**
	 * Visit a modulo node
	 *
	 * @param node the modulo node
	 */
	public void visit(ModuloNode node);
	
	/**
	 * Visit an and node
	 *
	 * @param node the and node
	 */
	public void visit(AndNode node);
	
	/**
	 * Visit an or node
	 *
	 * @param node the or node
	 */
	public void visit(OrNode node);
	
	/**
	 * Visit an equalTo node
	 *
	 * @param node the equalTo node
	 */
	public void visit(EqualToNode node);
	
	/**
	 * Visit a greaterThan node
	 *
	 * @param node the greaterThan node
	 */
	public void visit(GreaterThanNode node);
}
