package q3;

/**
 * 
 * @author Peng Tong
 * Infix Expression
 * 
 */

public class InfixExpression extends Expression{

	private String infixExpresion;
	private int id; // id of this node
	

	/**
	 * construct a new Infix Expression
	 * @param a operator and two number expressions
	 * @return a new Infix Expression with given operator and numbers
	 */
	@SuppressWarnings("static-access")
	public InfixExpression(Operator op, Expression num1, Expression num2) {
		this.infixExpresion = num1.textRepresentation() 
				+ " " + op.getOperator() 
				+ " " + num2.textRepresentation();
		this.id = super.nodeId;
		super.nodeId++;
		super.nodeSet.add(this);
	}
	
	/**
	 * @return a string that reflects the entire 
	 *           subtree rooted at current node
	 */
	@Override
	public String textRepresentation() {
		return infixExpresion;
	}

	/**
	* Returns unique identifier for each node.
	* @param no parameters
	* @return a int that indicates the id of this node
	*/
	@Override
	public int getId() {
		return id;
	}

}
