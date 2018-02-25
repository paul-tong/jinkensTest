package q3;

/**
 * 
 * @author Peng Tong
 * Prefix Expression
 * 
 */

public class PrefixExpression extends Expression{

	private String prefixExpresion;
	private int id;
	

	/**
	 * construct a new Prefix Expression
	 * @param a operator and two number expressions
	 * @return a new Prefix Expression with given operator and numbers
	 */
	@SuppressWarnings("static-access")
	public PrefixExpression(Operator op, Expression num1, Expression num2) {
		this.prefixExpresion = op.getOperator() 
				+ " " + num1.textRepresentation()  
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
		return prefixExpresion;
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
