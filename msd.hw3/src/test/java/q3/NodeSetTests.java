package q3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests for NodeSet
 * @author peng
 *
 */
public class NodeSetTests {
	
	public NodeFactory f = new NodeFactory(); // factory to create node
	
	/**
	 * test add method
	 */
	@Test
	public void testAdd() {
		NodeSet set = new NodeSet();
		Node n1 = f.createNumNode(11); 
		Node n2 = f.createNumNode(22);
		Node n3 = f.createStringNode("hehe");

		set.add(n1); // add new node, size increase
		assertEquals("add test1: ", set.size(), 1);
		set.add(n2);
		assertEquals("add test2: ", set.size(), 2);
		set.add(n3);
		assertEquals("add test3: ", set.size(), 3);
		
		set.add(n2); // add the exited node, size won't change
		assertEquals("add test4: ", set.size(), 3);	
	}
	
	/**
	 * test addALl method
	 */
	@Test
	public void testAddAll() {
		NodeSet set = new NodeSet();
		NodeSet set2 = new NodeSet();
		set.add(f.createNumNode(33));
		set.add(f.createNumNode(44));
		set.add(f.createNumNode(55));
		set.add(f.createStringNode("tp"));
		
		set2.addAll(set);
		assertEquals("addAll test1: ", set2.size(), 4);	
	}

	/**
	 * test contains method
	 */
	@Test
	public void testContains() {
		NodeSet set = new NodeSet();
        Node n1 = f.createNumNode(2.2);
        Node n2 = f.createNumNode(3.3);
        set.add(n1);
        
        assertEquals("contains test1: ", set.contains(n1), true);
        assertEquals("contains test2: ", set.contains(n2), false);
	}
	
	/**
	 * test remove method
	 */
	@Test
	public void testRemove() {
		NodeSet set = new NodeSet();
        Node n1 = f.createNumNode(1.1);
        Node n2 = f.createNumNode(2.2);
        Node n3 = f.createNumNode(3.3);
        set.add(n1);
        set.add(n2);
        
        set.remove(n1); // remove exist node
        assertEquals("remove test1: ", set.contains(n1), false);
        assertEquals("remove test2: ", set.contains(n2), true);
        assertEquals("remove test3: ", set.size(), 1);
        
        set.remove(n3); // remove non-exist node, do nothing
        assertEquals("remove test4: ", set.size(), 1);
	}
	
	/**
	 * test size method
	 */
	@Test
	public void testSize() {
		NodeSet set = new NodeSet();
        Node n1 = f.createStringNode("1");
        Node n2 = f.createStringNode("2");
        
        assertEquals("size test1: ", set.size(), 0); // no nodes
        set.add(n1);
        assertEquals("size test2: ", set.size(), 1); // add one node
        set.add(n2);
        assertEquals("size test3: ", set.size(), 2); // add two nodes
        set.remove(n1);
        assertEquals("size test4: ", set.size(), 1); // remove one node
	}
	
	/**
	 * test iterator
	 */
	@Test
	public void testIterator() {
		NodeSet set = new NodeSet();
        Node n1 = f.createStringNode("node1");
        Node n2 = f.createStringNode("node2");
        Node n3 = f.createStringNode("node3");
        set.add(n1);
        set.add(n2);
        set.add(n3);

        Iterator<Node> it = set.iterator();
        int i = 0;
        while (it.hasAnotherElement()) {
        	i++;
        	assertEquals("iterator test" + i + ": ", 
        			it.nextElement().textRepresentation(), "node" + i);
        }
	}
	
	/**
	 * test toString method
	 */
	@Test
	public void testToString() {
		NodeSet set = new NodeSet();
        Node n1 = f.createStringNode("node1");
        
        assertEquals("toString test1: ", set.toString(), ""); // empty set
        set.add(n1); // non-empty set
        assertEquals("toString test1: ", set.toString(), "node: " 
               + n1.textRepresentation() + " id: " + n1.getId()+"\n"); 
	}
	
}
