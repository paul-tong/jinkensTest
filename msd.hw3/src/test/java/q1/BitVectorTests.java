package q1;

import static org.junit.Assert.*;
import org.junit.Test;

import q1.BitVector;
import q1.IBitVector;
import q1.Iterator;


/**
 * test class for bitVector
 * @author peng
 *
 */
public class BitVectorTests {

	/**
	 * tests for get method
	 */
	@Test
	public void testGet() {
		IBitVector bv = new BitVector();
		
		assertEquals("get test1 fail", bv.get(-1), false); // i < 0
		assertEquals("get test2 fail", bv.get(33), false); // i > 32
		
		assertEquals("get test3 fail", bv.get(22), false); // false before set
		bv.set(22); // should be true after set
		assertEquals("get test4 fail", bv.get(22), true);
		bv.clear(22); // should be false after clear
		assertEquals("get test5 fail", bv.get(22), false);
	}
	
	/**
	 * test for set method
	 */
	@Test
	public void testSet() {
		IBitVector bv = new BitVector();
		
		bv.set(-1); // if set number < 0, get method will still return false
		assertEquals("set test1 fail", bv.get(-1), false); 
		
		bv.set(11); // set number in range [0, maxNum), get method will return true 
		assertEquals("set test2 fail", bv.get(11), true); 
		
		bv.set(35); // set number exceeds max range, will expand array first
		assertEquals("set test3 fail", bv.get(35), true); 
	}

	/**
	 * test for clear method
	 */
	@Test
	public void testClear() {
		IBitVector bv = new BitVector();
		
		bv.clear(-5); // if clear number < 0, get method return false
		assertEquals("set test1 fail", bv.get(-5), false); 
		
		bv.clear(36); // if clear number exceeds max range, get method return false
		assertEquals("set test1 fail", bv.get(36), false); 
		
		bv.set(11); // set number in range [0, maxNum), 
		bv.clear(11); // then clear it, will get false
		assertEquals("set test2 fail", bv.get(11), false); 
		
		bv.set(65); // set number exceeds max range
		bv.clear(65); // then clear it, will get false
		assertEquals("set test3 fail", bv.get(65), false); 
	}
	
	/**
	 * test for size method
	 */
	@Test
	public void testSize() {
		IBitVector bv = new BitVector();
		
		bv.set(-1); // set invalid num, size will not change
		assertEquals("size test1 fail", bv.size(), 0);
		
		bv.set(10); // set valid num, size++
		bv.set(11);
		assertEquals("size test2 fail", bv.size(), 2);
		
		bv.set(10); // set repeated num, size will not change
		assertEquals("size test3 fail", bv.size(), 2);
	
		bv.clear(9); // clear un-set number, size will not change
		assertEquals("size test4 fail", bv.size(), 2);
		
		bv.clear(10); // clear set-number, size--
		assertEquals("size test5 fail", bv.size(), 1);
		
		bv.clear(-1); // clear invalid number, size will not change
		assertEquals("size test6 fail", bv.size(), 1);
	}
	
	/**
	 * test for copy method
	 */
	@Test
	public void testCopy() {
		IBitVector a = new BitVector();
		a.set(1);
		a.set(2);
		a.set(33);
		a.set(55);
		
		IBitVector b = new BitVector();
		b.copy(a);
		assertEquals("copy test1 fail", b.size(), 4); // should has same size as a
		assertEquals("copy test2 fail", b.get(1), true); // should have the same set bits as a
		assertEquals("copy test3 fail", b.get(2), true);
		assertEquals("copy test4 fail", b.get(33), true);
		assertEquals("copy test5 fail", b.get(55), true);
	}
	
	/**
	 * test for iterator
	 */
	@Test
	public void testIterator() {
		IBitVector bv = new BitVector();
		Iterator<Integer> it = bv.iterator();
		
		assertEquals("iterator test1 fail", it.hasAnotherElement(), false); // has no element before setting

		bv.set(1); // set elements
		bv.set(22);
		bv.set(33);
		bv.set(66);
		
		assertEquals("iterator test2 fail", it.hasAnotherElement(), true); // has next element
		assertEquals("iterator test3 fail", it.nextElement(), Integer.valueOf(1));
		assertEquals("iterator test4 fail", it.nextElement(), Integer.valueOf(22));
		assertEquals("iterator test5 fail", it.nextElement(), Integer.valueOf(33));
		assertEquals("iterator test6 fail", it.nextElement(), Integer.valueOf(66));
		assertEquals("iterator test7 fail", it.hasAnotherElement(), false); // has no element
	}
	
}
