public interface Expression {

TreeNode buildTree(String[] exp);

int evalTree();

String toPrefixNotation();

String toInfixNotation();

String toPostfixNotation();

int postfixEval(String[] exp);
}