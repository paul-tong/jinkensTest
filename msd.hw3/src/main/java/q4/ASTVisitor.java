package q4;

/**
 * a interface of ASTVisitor
 * @author peng
 *
 */
public interface ASTVisitor {

	/**
	 * visit specific type of node
	 * @param n a VariableExpression node
	 * @return no returns
	 */
	public void visit(VariableExpression n);
	
	/**
	 * visit specific type of node
	 * @param n a StringExpression node
	 * @return no returns
	 */
	public void visit(StringExpression n);
	
	/**
	 * visit specific type of node
	 * @param n a NumberExpression node
	 * @return no returns
	 */
	public void visit(NumberExpression n);
	
	/**
	 * visit specific type of node
	 * @param n a InfixExpression node
	 * @return no returns
	 */
	public void visit(InfixExpression n);
	
	/**
	 * visit specific type of node
	 * @param n a PrefixExpression node
	 * @return no returns
	 */
	public void visit(PrefixExpression n);
	
	/**
	 * visit specific type of node
	 * @param n a Declaration node
	 * @return no returns
	 */
	public void visit(Declaration n);
	
	/**
	 * visit specific type of node
	 * @param n an Assignment node
	 * @return no returns
	 */
	public void visit(Assignment n);
	
	/**
	 * visit specific type of node
	 * @param n a Sequence node
	 * @return no returns
	 */
	public void visit(Sequence n);
	
}
