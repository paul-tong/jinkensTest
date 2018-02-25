package q3;

/**
 * 
 * @author Peng Tong
 * Number Expression
 * 
 */

public class NumberExpression extends Expression{

	private String numberExpression;
	private int id;
	
	/**
	 * construct a new Number Expression
	 * @param num a int type number 
	 * @return a new Number Expression with given num
	 */
	@SuppressWarnings("static-access")
	public NumberExpression(int num) {
		this.numberExpression = String.valueOf(num);
		this.id = super.nodeId;
		super.nodeId++;
		super.nodeSet.add(this);
	}
	
	/**
	 * construct a new Number Expression
	 * @param num a double type number 
	 * @return a new Number Expression with given num
	 */
	@SuppressWarnings("static-access")
	public NumberExpression(double num) {
		this.numberExpression = String.valueOf(num);
		this.id = super.nodeId;
		super.nodeId++;
		super.nodeSet.add(this);
	}
	
	/**
	 * @return a string that reflects the entire 
	 *           subtree rooted at current node
	 */
	public String textRepresentation() {
		return numberExpression;
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
