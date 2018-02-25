package q3;

/**
* Class NodeSet represents a set of AST Nodes.
*
*/
public class NodeSet implements Set<Node> {
	
	private IBitVector adaptee = new BitVector(); // bitVector saves nodes' id
	private int INITIAL_SIZE = 32; // initial size of node array
	private int curSize = INITIAL_SIZE; // current size of node array
	private Node[] nodes = new Node[INITIAL_SIZE];
	// private int number = 0; // number of nodes in node array

	// expand the size of node array to 2 times 
	private void expandArray() {
		Node[] newNodes = new Node[nodes.length * 2];
		for (int i = 0; i < nodes.length; i++) {
			newNodes[i] = nodes[i];
		}
		nodes = newNodes;
		curSize = nodes.length;
	}
	
	/**
	* Add an element
	* @param t A Node that needs to be added
	* @return no returns
	*/
	@Override
	public void add(Node t) {
		int id = t.getId();
		if (!contains(t)) { // not added before
			this.adaptee.set(id); // set id
			if (id >= this.curSize) { // if exceeds size
				this.expandArray(); // expand size
			}
			this.nodes[id] = t; // set node
		}
	}

	/**
	* Add all elements in the argument set
	* @param s A nodeSet that needs to be copied
	* @return no returns
	*/ 
	@Override
	public void addAll(Set<Node> s) {
		Iterator<Node> it = s.iterator();
		while (it.hasAnotherElement()) {
			this.add(it.nextElement());
		}
	}

	/**
	* Check if an element occurs in the set
	* @param t A node that needs check
	* @return true if given node is in the set
	*/
	@Override
	public boolean contains(Node t) {
		return this.adaptee.get(t.getId());
	}

	/**
	* Remove an element
	* @param t A node that needs to remove
	* @return no returns
	*/ 
	@Override
	public void remove(Node t) {
		int id = t.getId();
		if (contains(t)) { // if contains the given node
			this.adaptee.clear(id);
			this.nodes[id] = null;
		}
	}

	/**
	 * Return the number of nodes in the set
	 * @param no parameters
	 * @return the number of nodes in the set
	 */
	@Override
	public int size() {
		return this.adaptee.size(); // return the size of adaptee
	}

	/**
	* Return an iterator over the set
	* @param no parameters
	* @return a nodeIterator that iterates the set
	*/
	@Override
	public Iterator<Node> iterator() {
		return new NodeIterator();
	}
	
	/**
	* A iterator that iterates nodes in the nodeVector
	* 
	*/
	private class NodeIterator implements Iterator<Node> {
		private Iterator<Integer> it = NodeSet.this.adaptee.iterator();
		
		/**
		 * Check if there are more elements
		 * @param no parameters
		 * @return true if there is another node in the nodeVector
		 */
		@Override
		public boolean hasAnotherElement() {
			// TODO Auto-generated method stub
			return it.hasAnotherElement();
		}

		/**
		 * Return the next element
		 * @param no parameters
		 * @return a Node that presents the next element in the nodeVector
		 */
		@Override
		public Node nextElement() {
			int id = it.nextElement();
			return NodeSet.this.nodes[id];
		}
	}
	
	/**
	 * string representation of this node set
	 * @param no parameters
	 * @return a String that represents this set
	 */
	@Override
	public String toString() {
		String s = "";
		Iterator<Node> it = this.iterator();
		while (it.hasAnotherElement()) {
			Node node = it.nextElement();
			s += "node: " + node.textRepresentation()
					+ " id: " + node.getId() + "\n";
		}
		return s;
	}

}
