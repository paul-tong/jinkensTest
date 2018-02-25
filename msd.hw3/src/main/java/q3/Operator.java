package q3;

/**
 * 
 * @author Peng Tong
 * Represents Operator
 * 
 */

public class Operator {
	private String operator;

	/**
	 * construct a new Operator
	 * @param op the specific operator
	 * @return a new Operator with given operator
	 */
	public Operator(String op) {
		this.operator = op;
	}
	
	/**
	 * @param no parameter
	 * @return the operator
	 */
	public String getOperator() {
		return this.operator;
	}
}
