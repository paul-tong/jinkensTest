package q4;

/**
 * a ASTVisitor to search for nodes contains given variable
 * @author peng
 *
 */
public class ASTSearchVisitor implements ASTVisitor{
	String search; // the name of the variable that needs to search
	Set<Node> nodes = new NodeSet(); // set of nodes that contains the search variable
	
	/**
	 * constructor
	 * @param name A String that indicates the name 
	 *    of variable that needs to search
	 */
	ASTSearchVisitor (String name) {
		search = name;
	}
	
	/**
	 * visit specific type of node
	 * @param n a Declaration node
	 * @return no returns
	 */
	@Override
	public void visit(Declaration n) {
		if (n.getVariable().getName().equals(search)) {
			nodes.add(n);
		}
	}

	/**
	 * visit specific type of node
	 * @param n an Assignment node
	 * @return no returns
	 */
	@Override
	public void visit(Assignment n) {
		if (n.getVariable().getName().equals(search)) {
			nodes.add(n);
		}
	}

	/**
	 * visit specific type of node
	 * @param n a Sequence node
	 * @return no returns
	 */
	@Override
	public void visit(Sequence n) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void visit(VariableExpression n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringExpression n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NumberExpression n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(InfixExpression n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PrefixExpression n) {
		// TODO Auto-generated method stub
		
	}

}
