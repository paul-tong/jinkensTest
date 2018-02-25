package q2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests for queue
 * @author peng
 *
 */
public class QueueTests {

	/**
	 * tests for add method
	 */
	@Test
	public void testAdd() {
		IQueue<Integer> q = new Queue<Integer>();
		assertEquals("add test1 fail", q.add(1), true); // should return true after adding
		assertEquals("add test2 fail", q.add(22), true);
	}

	/**
	 * tests for remove method
	 */
	@Test
	public void testRemove() {
		IQueue<Integer> q = new Queue<Integer>();
		assertEquals("remove test1 fail", q.remove(), null); // return null when it's empty
		
		q.add(11);
		q.add(22);
		assertEquals("remove test2 fail", q.remove(), Integer.valueOf(11)); // return the first element
		assertEquals("remove test3 fail", q.remove(), Integer.valueOf(22)); // return next element
		assertEquals("remove test4 fail", q.remove(), null); // return empty
	}
	
	/**
	 * tests for peek method
	 */
	@Test
	public void testPeek() {
		IQueue<Integer> q = new Queue<Integer>();
		assertEquals("peek test1 fail", q.peek(), null); // return null when it's empty

		q.add(11);
		q.add(22);
		assertEquals("peek test2 fail", q.peek(), Integer.valueOf(11)); // always return the first element
		assertEquals("peek test3 fail", q.peek(), Integer.valueOf(11)); 
	}
}
