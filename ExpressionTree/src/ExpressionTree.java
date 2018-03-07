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
         return evalTree(this, this.getLeft(), this.getRight());
	}
	
	private int evalTree(TreeNode n,TreeNode l, TreeNode r) {
		if(n.getLeft() == null && n.getRight() == null) {
			return Integer.parseInt((String)n.getValue()) ;
		}
		String test = (String) n.getValue();
		switch(test){
			case "+": return (evalTree(l, l.getLeft(), l.getRight()) + evalTree(r, r.getLeft(), r.getRight()) );
			
			case "*": return (evalTree(l, l.getLeft(), l.getRight()) * evalTree(r, r.getLeft(), r.getRight()) );
			
			case "/": return (evalTree(l, l.getLeft(), l.getRight()) / evalTree(r, r.getLeft(), r.getRight()) );

			case "-": return (evalTree(l, l.getLeft(), l.getRight()) - evalTree(r, r.getLeft(), r.getRight()) );
			
			case "%": return (evalTree(l, l.getLeft(), l.getRight()) % evalTree(r, r.getLeft(), r.getRight()) );
			
			default: return 0;
		}
		
	}
	
	public String toPrefixNotation() {
		return ((String)this.getValue() + toPrefixNotation(this.getLeft()) + toPrefixNotation(this.getRight()));
	}
	
	private String toPrefixNotation(TreeNode n) {
		if(n.getLeft() == null) {
			return (String)n.getValue();
		}
		
		////////////////////////////////
		
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
