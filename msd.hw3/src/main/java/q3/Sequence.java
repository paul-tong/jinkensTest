package q3;


/**
 * 
 * @author Peng Tong
 * Sequence Statement
 * 
 */

public class Sequence extends Statement{

	private String sequenceStatement;
	private int id;
	
	/**
	 * construct a new Sequence Statement
	 * @param two statements
	 * @return a new Sequence Statement with given two statements
	 */
	@SuppressWarnings("static-access")
	public Sequence(Statement s1, Statement s2) {
		this.sequenceStatement = s1.textRepresentation() 
				+ " " + s2.textRepresentation();
		this.id = super.nodeId;
		super.nodeId++;
		super.nodeSet.add(this);
	}
	
	/**
	 * construct a new Sequence Statement
	 * @param a set of statements
	 * @return a new Sequence Statement with given statements
	 */
	@SuppressWarnings("static-access")
	public Sequence(Set<Node> nodes) {
		Iterator<Node> it = nodes.iterator();
		while (it.hasAnotherElement()) {
			this.sequenceStatement += it.nextElement().textRepresentation();
		}

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
		return sequenceStatement;
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
