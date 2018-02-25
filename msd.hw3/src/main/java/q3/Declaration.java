package q3;

/**
 * 
 * @author Peng Tong
 * Declaration statement
 * 
 */

public class Declaration extends Statement{

	private String declarationStatement;
	private int id;
	
	/**
	 * construct a new Declaration Statement
	 * @param a variable
	 * @return a new Declaration Statement with given variable
	 */
	@SuppressWarnings("static-access")
	public Declaration(Variable v) {
		this.declarationStatement = "var " + v.getName() + ";";
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
		return declarationStatement;
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
