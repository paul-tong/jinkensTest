package q3;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * test new methods in Node
 * @author peng
 *
 */
public class NodeTests {
	
	public NodeFactory f = new NodeFactory(); // factory to create node

	/**
	 * test getId
	 */
	@Test
	public void testGetId() {
		Node n1 = f.createNumNode(11); 		
		assertEquals("getId test1: ", n1.getId(), 0);
		Node n2 = f.createNumNode(22);
		assertEquals("getId test2: ", n2.getId(), 1);
		Node n3 = f.createStringNode("hehe");
		assertEquals("getId test3: ", n3.getId(), 2);
	}

	/**
	 * test getNode without exception
	 */
	@Test
	public void testGetNode() {
		Node n1 = f.createStringNode("node1");
		Node n2 = f.createStringNode("node2");
		
		assertEquals("getNode test1: ", Node.getNode(n1.getId()), n1);
		assertEquals("getNode test2: ", Node.getNode(n2.getId()), n2);
	}
	
	/**
	 * test getId with exception
	 */
	@Test(expected = NoSuchElementException.class)
	public void testGetIdException() {
		Node n1 = f.createNumNode(1.1);
		Node.nodeSet.remove(n1);
		assertEquals("getNode exception test1: ", Node.getNode(n1.getId()), n1);
	}
	
}
