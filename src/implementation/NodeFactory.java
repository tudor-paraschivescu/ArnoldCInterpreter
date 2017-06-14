package implementation;

import nodes.AndNode;
import nodes.ArnoldNode;
import nodes.AssignmentNode;
import nodes.ConstantNode;
import nodes.DeclareNode;
import nodes.DifferenceNode;
import nodes.DivisionNode;
import nodes.ElseBodyNode;
import nodes.EqualToNode;
import nodes.GreaterThanNode;
import nodes.IfNode;
import nodes.LValNode;
import nodes.LeafNode;
import nodes.ModuloNode;
import nodes.MultiplicationNode;
import nodes.OrNode;
import nodes.PrintNode;
import nodes.RValNode;
import nodes.StringNode;
import nodes.SumNode;
import nodes.TreeNode;
import nodes.VariableNode;
import nodes.WhileNode;

/**
 * A factory for creating Node objects.
 * 
 * @author Tudor Paraschivescu
 */
public final class NodeFactory {

	/*
	"BECAUSE I'M GOING TO SAY PLEASE",		// 0. If
	"BULLSHIT",								// 1. Else
	"YOU HAVE NO RESPECT FOR LOGIC",		// 2. EndIf
	"STICK AROUND",							// 3. While
	"CHILL",								// 4. EndWhile
	"GET UP",								// 5. PlusOperator
	"GET DOWN",								// 6. MinusOperator
	"YOU'RE FIRED",							// 7. MultiplicationOperator
	"HE HAD TO SPLIT",						// 8. DivisionOperator
	"I LET HIM GO",							// 9. ModuloOperator
	"YOU ARE NOT YOU YOU ARE ME",			// 10. EqualTo
	"LET OFF SOME STEAM BENNET",			// 11. GreaterThan
	"CONSIDER THAT A DIVORCE",				// 12. Or 
	"KNOCK KNOCK",							// 13. And
	"HEY CHRISTMAS TREE",					// 14. DeclareInt
	"YOU SET US UP",						// 15. SetInitialValue
	"IT'S SHOWTIME",						// 16. BeginMain
	"YOU HAVE BEEN TERMINATED",				// 17. EndMain
	"TALK TO THE HAND",						// 18. Print
	"GET TO THE CHOPPER",					// 19. AssignVariable
	"HERE IS MY INVITATION",				// 20. SetValue
	"ENOUGH TALK",							// 21. EndAssignVariable
	"@I LIED",								// 22. False
	"@NO PROBLEMO"							// 23. True
	*/
	
	/**
	 * Creates a new Node object.
	 *
	 * @param code the code of the expression
	 * @param currentNode the current node
	 * @param line the input line 
	 * @return the new current tree node or null
	 */
	public TreeNode createNode(int code, TreeNode currentNode, String line) {

		// The possible argument of an expression
		String arg;
		
		// A new leaf that might be added
		LeafNode newLeaf;
		
		// An old node that might be moved
		ArnoldNode oldNode;

		switch (code) {

		case 0:
			// Get the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[0].length() + 1);
			IfNode ifNode = new IfNode(currentNode, arg);

			// subNode #0 - ConditionNode, subNode #1 - IfBodyNode
			return (TreeNode) (ifNode.getSubNodes().get(1));

		case 1:
			// In this moment, the current node is IfBodyNode
			// Change the current node to IfNode
			currentNode = currentNode.getParent();
			ElseBodyNode elseNode = new ElseBodyNode(currentNode);

			// The current node will be the else body node
			return elseNode;

		case 2:
			// Exit the current body node (if or else) and the if node
			return currentNode.getParent().getParent();

		case 3:
			// Get the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[3].length() + 1);
			WhileNode whileNode = new WhileNode(currentNode, arg);

			// The current node changes to while body node
			return whileNode.getBody();

		case 4:
			// Exit the current body node and the while node
			return currentNode.getParent().getParent();
			
		case 5:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[5].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new sum node
			SumNode sumNode = new SumNode(currentNode);
			
			// Add the old node to the sum node
			oldNode.setParent(sumNode);
			
			// Add the new node to the sum node
			newLeaf.setParent(sumNode);
			
			return null;
			
		case 6:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[6].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new difference node
			DifferenceNode diffNode = new DifferenceNode(currentNode);
			
			// Add the old node to the difference node
			oldNode.setParent(diffNode);
			
			// Add the new node to the difference node
			newLeaf.setParent(diffNode);
			
			return null;
			
		case 7:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[7].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new multiplication node
			MultiplicationNode mulNode = new MultiplicationNode(currentNode);
			
			// Add the old node to the multiplication node
			oldNode.setParent(mulNode);
			
			// Add the new node to the multiplication node
			newLeaf.setParent(mulNode);
			
			return null;
			
		case 8:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[8].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new division node
			DivisionNode divNode = new DivisionNode(currentNode);
			
			// Add the old node to the division node
			oldNode.setParent(divNode);
			
			// Add the new node to the division node
			newLeaf.setParent(divNode);
			
			return null;
			
		case 9:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[9].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new modulo node
			ModuloNode modNode = new ModuloNode(currentNode);
			
			// Add the old node to the modulo node
			oldNode.setParent(modNode);
			
			// Add the new node to the modulo node
			newLeaf.setParent(modNode);
			
			return null;
			
		case 10:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[10].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new equalTo node
			EqualToNode eqNode = new EqualToNode(currentNode);
			
			// Add the old node to the equalTo node
			oldNode.setParent(eqNode);
			
			// Add the new node to the equalTo node
			newLeaf.setParent(eqNode);
			
			return null;
			
		case 11:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[11].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new greaterThan node
			GreaterThanNode grNode = new GreaterThanNode(currentNode);
			
			// Add the old node to the greaterThan node
			oldNode.setParent(grNode);
			
			// Add the new node to the greaterThan node
			newLeaf.setParent(grNode);
			
			return null;			
			
		case 12:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[12].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new or node
			OrNode orNode = new OrNode(currentNode);
			
			// Add the old node to the or node
			oldNode.setParent(orNode);
			
			// Add the new node to the or node
			newLeaf.setParent(orNode);
			
			return null;			
			
		case 13:
			// Get the name of the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[13].length() + 1);
			
			// Create the new leaf
			newLeaf = createNewLeaf(currentNode, arg);
			
			// Remove the old node from the right of the assignment node
			oldNode = currentNode.getSubNodes().remove(1);
			
			// Create the new and node
			AndNode andNode = new AndNode(currentNode);
			
			// Add the old node to the and node
			oldNode.setParent(andNode);
			
			// Add the new node to the and node
			newLeaf.setParent(andNode);
			
			return null;

		case 14:
			// Get the name of the variable
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[14].length() + 1);

			// Create the declare node
			DeclareNode dNode = new DeclareNode(currentNode);

			// Create the LValNode that is a variable with name arg
			new LValNode(dNode, arg);

			// The declare node is the current node until
			// the variable is initialised
			return dNode;

		case 15:
			// Get the value of the variable
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[15].length() + 1);

			if (arg.equals(ArnoldCFileParser.ARNOLDC_WORDS[22])) {
				// The new variable is initialised to I LIED
				new ConstantNode(currentNode, 0);
			} else if (arg.equals(ArnoldCFileParser.ARNOLDC_WORDS[23])) {
				// The new variable is initialised to NO PROBLEMO
				new ConstantNode(currentNode, 1);
			} else {
				// The new variable is initialised to an integer
				new ConstantNode(currentNode, Integer.parseInt(arg));
			}

			// Declaration is finished and the current node will be the parent
			return currentNode.getParent();

		case 16:
			return null;

		case 17:
			return null;

		case 18:
			PrintNode printNode = new PrintNode(currentNode);

			// Get the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[18].length() + 1);

			if (arg.startsWith("\"")) {
				// The argument is a string
				new StringNode(printNode, arg.substring(1, arg.length() - 1));
			} else if (Character.isDigit(arg.charAt(0))) {
				// The argument is a number
				int value = Integer.parseInt(arg);
				new ConstantNode(printNode, value);
			} else {
				// The argument is a variable
				new VariableNode(printNode, arg);
			}

			return null;
			
		case 19:
			// Get the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[19].length() + 1);
			// Create the new assignment node
			AssignmentNode assignNode = new AssignmentNode(currentNode, arg);
			
			// The assignment node becomes the current node
			return assignNode;
			
		case 20:
			// Get the argument
			arg = line.substring(ArnoldCFileParser.ARNOLDC_WORDS[20].length() + 1);
			
			createNewLeaf(currentNode, arg);
			
			return null;
		
		case 21:
			// Assignment is finished and the current node will be the parent
			return currentNode.getParent();
			
		default:
			return null;
		}
	}
	
	// Creates a new Leaf Node
	private LeafNode createNewLeaf(TreeNode current, String name) {
		
		if (Character.isDigit(name.charAt(0))) {
			// The argument is a number
			int value = Integer.parseInt(name);
			return new ConstantNode(current, value);
		}
		else if (name.equals(ArnoldCFileParser.ARNOLDC_WORDS[22])) {
			// The new variable is initialised to I LIED
			return new ConstantNode(current, 0);
		}
		else if (name.equals(ArnoldCFileParser.ARNOLDC_WORDS[23])) {
			// The new variable is initialised to NO PROBLEMO
			return new ConstantNode(current, 1);
		}
		else {
			// The argument is a variable
			return new RValNode(current, name);
		}
	}
	
}
