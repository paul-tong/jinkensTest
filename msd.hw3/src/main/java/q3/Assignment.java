package q3;

/**
 * 
 * @author Peng Tong
 * Assignment statement
 * 
 */

public class Assignment extends Statement{

	private String assignStatement; // text string of this node
	private int id; // id of this node
	
	/**
	 * construct a new assignment statement
	 * @param a variable and an expression
	 * @return a new assignment statement with given variable and expression 
	 */
	@SuppressWarnings("static-access")
	public Assignment(Variable v, Expression e) {
		this.assignStatement = v.getName() + " = " + e.textRepresentation() + ";"; 
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
		return this.assignStatement;
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
