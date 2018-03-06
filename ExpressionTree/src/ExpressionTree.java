import java.util.*;
public class ExpressionTree extends TreeNode implements Expression {
	private Stack<TreeNode> objStack = new Stack<TreeNode>();
	public ExpressionTree(String str) {
		super(str);
	}
	public TreeNode buildTree(String[] exp) {
		
		for( int i = 0; i < exp.length; i++ ) {
			TreeNode x = new TreeNode(exp[i]);
			objStack.push(x);
		}
		
		Stack<TreeNode> temp = new Stack<TreeNode>();
		
		while(!objStack.isEmpty()) {
			if(isOperator(objStack.peek())) {
				TreeNode leftTree = null;
				TreeNode rightTree = null;
				if(!temp.isEmpty())
					leftTree = temp.pop();
				if(!temp.isEmpty())
					rightTree = temp.pop();
				TreeNode toAdd = new TreeNode(objStack.pop(), leftTree, rightTree);
				if(objStack.isEmpty())
					return toAdd;
				objStack.push(toAdd);
			}
			else {
				temp.push(objStack.pop());
			}
		}
		return null;
	 
	}
	public int evalTree() {
		
	}
	public String toPrefixNotation() {
		
	}
	public String toInfixNotation() {
		
	}
	public String toPostfixNotation() {
		
	}
	public int postfixEval(String[] exp) {
		
	}
	public boolean isOperator(TreeNode tree) {

		String str = (String) tree.getValue();
		
		if(str.equals("+")||str.equals("*")||str.equals("/")||str.equals("-")||str.equals("%"))
			return true;
		return false;
	}

}
