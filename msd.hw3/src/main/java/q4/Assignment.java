package q4;

/**
 * 
 * @author Peng Tong
 * Assignment statement
 * 
 */

public class Assignment extends Statement{

	private String assignStatement; // text string of this node
	private int id; // id of this node
	private Variable v;
	private Expression e;
	
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
		this.v = v;
		this.e = e;
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
	
	/**
	 * accept a ASTVisitor to visit this node
	 * @param v A ASTVistor that will visit this node
	 * @return no returns
	 */
	@Override
	public void accept(ASTVisitor v) {
		v.visit(this);
		this.e.accept(v);
	}

	/**
	 * get the variable of this assignment
	 * @param no parameters
	 * @return the variable of this assignment
	 */
	public Variable getVariable() {
		return this.v;
	}
}
