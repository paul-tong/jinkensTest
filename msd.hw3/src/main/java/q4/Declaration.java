package q4;

/**
 * 
 * @author Peng Tong
 * Declaration statement
 * 
 */

public class Declaration extends Statement{

	private String declarationStatement;
	private int id;
	private Variable v;
	
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
		this.v = v;
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

	/**
	 * accept a ASTVisitor to visit this node
	 * @param v A ASTVistor that will visit this node
	 * @return no returns
	 */
	@Override
	public void accept(ASTVisitor v) {
		v.visit(this);
	}
	
	/**
	 * get the variable of this declaration 
	 * @param no parameters
	 * @return the variable of this declaration
	 */
	public Variable getVariable() {
		return this.v;
	}
}
