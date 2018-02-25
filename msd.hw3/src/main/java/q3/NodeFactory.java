package q3;

/**
 * factory to create nodes
 * @author peng
 *
 */
public class NodeFactory {
		
	/**
	 * create Variable Expression Node
	 * @param v a Variable
	 * @return a VariableExpression
	 */
	public Expression createVarNode(Variable v) {
		return new VariableExpression(v);
	}
	
	/**
	 * create String Expression Node
	 * @param s A String
	 * @return a StringExpression
	 */
	public Expression createStringNode(String s) {
		return new StringExpression(s);
	}
	
	/**
	 * create Number Expression Node with int
	 * @param num A int
	 * @return a NumberExpression
	 */
	public Expression createNumNode(int num) {
		return new NumberExpression(num);
	}
	
	/**
	 * create Number Expression Node with double
	 * @param num A double
	 * @return a NumberExpression
	 */
	public Expression createNumNode(double num) {
		return new NumberExpression(num);
	}
	
	/**
	 * create Infix Expression Node
	 * @param op A operation, num1 A Expression, num1 A Expression
	 * @return a InfixExpression
	 */
	public Expression createInfixNode(Operator op, Expression num1, Expression num2) {
		return new InfixExpression(op, num1, num2);
	}
	
	/**
	 * create Prefix Expression Node
	 * @param op A operation, num1 A Expression, num1 A Expression
	 * @return a PrefixExpression
	 */
	public Expression createPrefixNode(Operator op, Expression num1, Expression num2) {
		return new PrefixExpression(op, num1, num2);
	}
	
	/**
	 * create Declaration Statement Node
	 * @param v A Variable
	 * @return a Declaration
	 */
	public Statement createDeclNode(Variable v) {
		return new Declaration(v);
	}
	
	/**
	 * create Assignment Statement Node
	 * @param v A Variable, e A Expression
	 * @return a Assignment
	 */
	public Statement createAssignNode(Variable v, Expression e) {
		return new Assignment(v, e);
	}
	
	/**
	 * create Sequence Statement Node
	 * @param s1, s2, both are Statement
	 * @return A Sequence
	 */
	public Statement createSequenceNode(Statement s1, Statement s2) {
		return new Sequence(s1, s2);
	}
	
}
