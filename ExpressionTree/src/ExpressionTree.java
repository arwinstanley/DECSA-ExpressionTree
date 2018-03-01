import java.util.*;
public class ExpressionTree extends TreeNode implements Expression {
	private Stack<Object> objStack = new Stack<Object>();
	public ExpressionTree(String str) {
		super(str);
	}
	public TreeNode buildTree(String[] exp) {
		for( int i = 0 )
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
	public boolean isOperator(String str) {
		if(str.equals("+")||str.equals("*"))
			return true;
		return false;
	}

}
