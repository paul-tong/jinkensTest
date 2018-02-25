package q3;

/**
 * 
 * @author Peng Tong
 * Represents Variable
 * 
 */

public class Variable {
	private String name;
	
	/**
	 * construct a new Variable
	 * @param s the name of the variable
	 * @return a new Variable with given name
	 */
	public Variable(String s) {
		this.name = s;
	}
	
	/**
	 * return the name of the variable
	 * @param no parameter
	 * @return the name of the variable
	 */
	public String getName() {
		return this.name;
	}
}
