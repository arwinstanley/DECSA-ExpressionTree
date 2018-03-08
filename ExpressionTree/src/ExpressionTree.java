import java.util.*;
public class ExpressionTree extends TreeNode implements Expression {
	private Stack<TreeNode> objStack = new Stack<TreeNode>();
	public ExpressionTree(String[] str) {
		super("");
		TreeNode temp = buildTree(str);
		this.setValue(temp);
		this.setLeft(temp.getLeft());
		this.setRight(temp.getRight());
		
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
         return evalTree(this);
	}
	
	private int evalTree(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) {
			return Integer.parseInt((String)n.getValue()) ;
		}
		String test = (String) n.getValue();
		switch(test){
			case "+": return (evalTree(n.getLeft()) + evalTree(n.getRight()));
			
			case "*": return (evalTree(n.getLeft()) * evalTree(n.getRight()));
			
			case "/": return (evalTree(n.getLeft()) / evalTree(n.getRight()));

			case "-": return (evalTree(n.getLeft()) - evalTree(n.getRight()));
			
			case "%": return (evalTree(n.getLeft()) % evalTree(n.getRight()));
			
			default: return 0;
		}
		
	}
	
	public String toPrefixNotation() {
		return toPrefixNotation(this);
	}
	
	private String toPrefixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return (String)n.getValue();
		return ((String)n.getValue())+ toPrefixNotation(n.getLeft()) + toPrefixNotation(n.getRight());
	}
	public String toInfixNotation() {
		return toInfixNotation(this);
	}
	private String toInfixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return (String)n.getValue();
		return "(" + toInfixNotation(n.getLeft())+ ((String)n.getValue()) + toInfixNotation(n.getRight()) + ")";
	}
	public String toPostfixNotation() {
		return toPostfixNotation(this);
	}
	private String toPostfixNotation(TreeNode n) {
		if(n.getLeft() == null && n.getRight() == null) 
			return (String)n.getValue();
		return toPostfixNotation(n.getLeft())+toPostfixNotation(n.getRight())+ ((String)n.getValue());
	}
	public int postfixEval(String[] exp) {
		Stack<Integer> eval = new Stack<Integer>();
		int out = 0;
		for(String s: exp) {
			if(!isOperator(s)) 
				eval.push(Integer.parseInt(s));
			else
				switch(s){
				case "+": eval.push(eval.pop() + eval.pop());
				
				case "*": eval.push(eval.pop() * eval.pop());
				
				case "/": eval.push(eval.pop() / eval.pop());

				case "-": eval.push(eval.pop() - eval.pop());
				
				case "%": eval.push(eval.pop() % eval.pop());
				}	
		}
		return eval.pop();
	}
	public boolean isOperator(TreeNode tree) {

		String str = (String) tree.getValue();
		
		if(str.equals("+")||str.equals("*")||str.equals("/")||str.equals("-")||str.equals("%"))
			return true;
		return false;
	}
	public boolean isOperator(String str) {
		if(str.equals("+")||str.equals("*")||str.equals("/")||str.equals("-")||str.equals("%"))
			return true;
		return false;
	}

}
