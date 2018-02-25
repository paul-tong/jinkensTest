package q4;

public class ASTNodeCountVisitor implements ASTVisitor{

	int varCount = 0; // count of different type of nodes
	int strCount = 0;
	int numCount = 0;
	int infixCount = 0;
	int prefixCount = 0;
	int decCount = 0;
	int assignCount = 0;
	int seqCount = 0;
	
	
	/**
	 * visit specific type of node
	 * @param n a VariableExpression node
	 * @return no returns
	 */
	@Override
	public void visit(VariableExpression n) {
		this.varCount++;		
	}

/*	public void visit(Variable n) {
		this.varCount++;		
	}*/
	
	/**
	 * visit specific type of node
	 * @param n a StringExpression node
	 * @return no returns
	 */
	@Override
	public void visit(StringExpression n) {
		this.strCount++;		
	}

	/**
	 * visit specific type of node
	 * @param n a NumberExpression node
	 * @return no returns
	 */
	@Override
	public void visit(NumberExpression n) {
		this.numCount++;
	}

	/**
	 * visit specific type of node
	 * @param n a InfixExpression node
	 * @return no returns
	 */
	@Override
	public void visit(InfixExpression n) {
		this.infixCount++;
		
	}

	/**
	 * visit specific type of node
	 * @param n a PrefixExpression node
	 * @return no returns
	 */
	@Override
	public void visit(PrefixExpression n) {
		this.prefixCount++;		
	}

	/**
	 * visit specific type of node
	 * @param n a Declaration node
	 * @return no returns
	 */
	@Override
	public void visit(Declaration n) {
		this.decCount++;		
	}

	/**
	 * visit specific type of node
	 * @param n a Assignment node
	 * @return no returns
	 */
	@Override
	public void visit(Assignment n) {
		this.assignCount++;		
	}

	/**
	 * visit specific type of node
	 * @param n a Sequence node
	 * @return no returns
	 */
	@Override
	public void visit(Sequence n) {
		this.seqCount++;		
	}

	/**
	 * report the count of each type of node
	 */
	public void report() {
		System.out.println("variable: " + varCount);
		System.out.println("string: " + strCount);
		System.out.println("number: " + numCount);
		System.out.println("infix: " + infixCount);
		System.out.println("prefix: " + prefixCount);
		System.out.println("declaration: " + decCount);
		System.out.println("assignment: " + assignCount);
		System.out.println("sequence: " + seqCount);
	}
}

