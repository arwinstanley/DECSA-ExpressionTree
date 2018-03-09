	/**
	 * @author Prof. Kelly (Edited by alex Winstanley)
	 * @Date 3/8/18
	 * This class is an interface outlining
	 */
public interface Expression {
	/**
	* 
	* Creates a default Disk with a radius of 0
	* 
	* @param exp an array of strings which is an expression in postfix notation 
	* @return the root of the TreeNode representing an expression tree
	*/
TreeNode buildTree(String[] exp);
	/**
	 * 
	 * evaluates the tree to an integer
	 * 
	 * @param none
	 * @return an int value that the expression tree equals 
	 */
int evalTree();
	/**
	 * 
	 * evaluates the tree into prefix notation
	 * 
	 * @param none
	 * @return a String of the expression in prefix notation
	 */
String toPrefixNotation();
	/**
	 * 
	 * evaluates the tree into infix notation with parenthesis to separate
	 * 
	 * @param none
	 * @return a String of the expression in infix notation
	 */
String toInfixNotation();
	/**
 	* 
 	* evaluates the tree into postfix notation
 	* 
 	* @param none
 	* @return a String of the expression in postfix notation
 	*/
String toPostfixNotation();
	/**
 	* 
 	* evaluates a post fix expression passed in with a String array
 	* 
 	* @param exp is the array representing the expression
 	* @return a String of the expression in prefix notation
 	*/
int postfixEval(String[] exp);
}
