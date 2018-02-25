package q3;

import java.util.NoSuchElementException;

/**
 * a node
 * @author peng
 *
 */
public abstract class Node {
	
	public static int nodeId = 0; // unique node id
	public static Set<Node> nodeSet = new NodeSet(); // set that contains nodes
	
	/**
	 * Reflects the entire subtree rooted at current node
	 * @param no parameters
	 * @return a string that reflects the entire 
	 *           subtree rooted at current node
	 */
	public abstract String textRepresentation();
	
	/**
	* Returns unique identifier for each node.
	* @param no parameters
	* @return a int that indicates the id of this node
	*/
	public abstract int getId();
	
	/**
	* Reverse mapping from Nodes to their unique identifiers
	* @param id a int that indicates the id of a node
	* @return a node that with given id
	*/
	public static Node getNode(int id) {
		Iterator<Node> it = nodeSet.iterator();
		while (it.hasAnotherElement()) {
			Node node = it.nextElement();
			if (node.getId() == id) {
				return node;
			}
		}
		throw new NoSuchElementException();
	}
}
