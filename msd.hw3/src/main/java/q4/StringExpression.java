package q4;

/**
 * 
 * @author Peng Tong
 * String Expression
 * 
 */

public class StringExpression extends Expression{

	private String stringExpression;
	private int id;
	
	/**
	 * construct a new string Expression
	 * @param s a String 
	 * @return a new String Expression with given string
	 */
	@SuppressWarnings("static-access")
	public StringExpression(String s) {
		this.stringExpression = s;
		this.id = super.nodeId;
		super.nodeId++;
		super.nodeSet.add(this);
		super.nodeSet.add(this);
	}
	
	/**
	 * @return a string that reflects the entire 
	 *           subtree rooted at current node
	 */
	@Override
	public String textRepresentation() {
		return stringExpression;
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
}
