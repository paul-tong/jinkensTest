package q4;

/**
 * 
 * @author Peng Tong
 * Variable Expression
 * 
 */

public class VariableExpression extends Expression{

	private String variableExpression;
	private int id;
	
	/**
	 * construct a new Variable Expression
	 * @param v a Variable 
	 * @return a new variable Expression with given variable
	 */
	@SuppressWarnings("static-access")
	public VariableExpression(Variable v) {
		this.variableExpression = v.getName();
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
		return variableExpression;
	}

	/**
	* Returns unique identifier for each node.
	* @param no parameters
	* @return a int that indicates the id of this node
	*/
	@Override
	public int getId() {
		// TODO Auto-generated method stub
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
