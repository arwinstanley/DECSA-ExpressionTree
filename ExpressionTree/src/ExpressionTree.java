	/**
	 * @author arwinstanley
	 * @Date 3/8/18
	 * This class is to represent an expressionTree extending treeNode and implementing the Expression interface
	 */
import java.util.*;
public class ExpressionTree extends TreeNode implements Expression {
	private Stack<TreeNode> objStack = new Stack<TreeNode>();
	/**
	* 
	* One parameter constructor for ExpressionTree uses the super constructor from TreeNode
	* 
	* @param exp an array of strings which is an expression in postfix notation 
	* @return the root of the TreeNode representing an expression tree
	*/
	public ExpressionTree(String[] str) {
		super(" ");
		TreeNode temp = buildTree(str);
		this.setValue(temp.getValue()+"");
		this.setLeft(temp.getLeft());
		this.setRight(temp.getRight());
		
	}
	@Override
	public TreeNode buildTree(String[] exp) {

		for(String x: exp) {
			TreeNode ele = new TreeNode(x);
			if(isOperator(ele)) {
				TreeNode leftTree = objStack.pop();
				TreeNode rightTree = objStack.pop();
				TreeNode toAdd = new TreeNode((ele.getValue()+""), rightTree, leftTree);
				objStack.push(toAdd);
			}
			else {
				objStack.push(ele);
			}
		}
	
			return objStack.pop();
	 
	}
	@Override
	public int evalTree() {
         return evalTree(this);
	}
	/**
	 * 
	 * evaluates the tree to an integer
	 * 
	 * @param n is the TreeNode used for recursion
	 * @return an int value that the expression tree equals 
	 */
	private int evalTree(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) {
			return Integer.parseInt(n.getValue()+"") ;
		}
		String test = n.getValue()+"";
		switch(test){
			case "+": return (evalTree(n.getLeft()) + evalTree(n.getRight()));
			
			case "*": return (evalTree(n.getLeft()) * evalTree(n.getRight()));
/*			
			case "/": return (evalTree(n.getLeft()) / evalTree(n.getRight()));

			case "-": return (evalTree(n.getLeft()) - evalTree(n.getRight()));   ///// These have not been bug tested so they are 
																					   Being commented out
			case "%": return (evalTree(n.getLeft()) % evalTree(n.getRight()));
*/			
			default: return 0;
		}
		
	}
	@Override
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}
	/**
	 * 
	 * evaluates the tree into prefix notation
	 * 
	 * @param n the TreeNode for recursion
	 * @return a String of the expression in prefix notation
	 */
	private String toPrefixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return n.getValue()+"";
		return (n.getValue()+"")+ toPrefixNotation(n.getLeft()) + toPrefixNotation(n.getRight());
	}
	@Override
	public String toInfixNotation() {
		return (toInfixNotation(this)).substring(1, (toInfixNotation(this).lastIndexOf(')')));
	}
	/**
	 * 
	 * evaluates the tree into infix notation with parenthesis to separate
	 * 
	 * @param n the TreeNode for recursion
	 * @return a String of the expression in infix notation
	 */
	private String toInfixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return n.getValue()+"";
		return "(" + toInfixNotation(n.getLeft())+ (n.getValue()+"") + toInfixNotation(n.getRight()) + ")";
	}
	@Override
	public String toPostfixNotation() {
		return toPostfixNotation(this);
	}
	/**
 	* 
 	* evaluates the tree into postfix notation
 	* 
 	* @param n is a TreeNode used for recursion
 	* @return a String of the expression in postfix notation
 	*/
	private String toPostfixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return n.getValue()+"";
		return toPostfixNotation(n.getLeft())+toPostfixNotation(n.getRight())+ (n.getValue()+"");
	}
	@Override
	public int postfixEval(String[] exp) {
		Stack<Integer> eval = new Stack<Integer>();
		for(String s: exp) {
			if(!isOperator(s)) 
				eval.push(Integer.parseInt(s));
			else
				switch(s){
				case "+": eval.push(eval.pop() + eval.pop());
				break;
				case "*": eval.push(eval.pop() * eval.pop());
				break;
/*				case "/": eval.push(eval.pop() / eval.pop());
				break;
				case "-": eval.push(eval.pop() - eval.pop());          //////Same here
				break;
				case "%": eval.push(eval.pop() % eval.pop());
				break;        */
				}	
		}
		return eval.pop();
	}
	/**
 	* 
 	* checks if the treenode is an operator
 	* 
 	* @param tree is aTreeNode to test
 	* @return true if the true node represents an operator
 	*/
	public boolean isOperator(TreeNode tree) {

		String str = tree.getValue()+"";
		
		if(str.equals("+")||str.equals("*")/*||str.equals("/")||str.equals("-")||str.equals("%")*/)
			return true;
		return false;
	}
	/**
 	* 
 	* checks if the string is an operator
 	* 
 	* @param tree is a String to test
 	* @return true if the true node represents an operator
 	*/
	public boolean isOperator(String str) {
		if(str.equals("+")||str.equals("*")/*||str.equals("/")||str.equals("-")||str.equals("%")*/)
			return true;
		return false;
	}

}
