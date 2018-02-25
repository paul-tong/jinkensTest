package q1;

import java.util.NoSuchElementException;

/**
 * A bitvector.
 * @author peng
 *
 */

public class BitVector implements IBitVector {

	private int INITIAL_SIZE = 1; // initial size of the vector
	private int curSize = INITIAL_SIZE; // current size of the vector
	private int[] ints = new int[INITIAL_SIZE]; // array that contains integers
	private int number = 0; // number of integers in the vector
	
	// expand the ints array to the new size
	private void expandArray(int newSize) {
		int[] newInts = new int[newSize];
		for (int i = 0; i < curSize; i++) {
			newInts[i] = ints[i];
		}
		ints = newInts;
		curSize = newSize;
	}
	
			
	/**
	 * Determine if the bit at position i is set.
	 * @param i A int that indicates the number needed to get
	 * @return true if the given number is already set
	 */
	@Override
	public boolean get(int i) {
		if (i >= curSize * 32 || i < 0) { 
			return false; // return false if i < 0 or exceed max range
		}
		
		int p1 = i / 32;
		int p2 = i % 32;
		int num = ints[p1];
		return ((num >> p2) & 1) == 1;
	}

	/**
	 * Set the bit at position i.
	 * @param i A int that indicates the number needed to set
	 * @return no return
	 */
	@Override
	public void set(int i) {
		if (i >= curSize * 32) { // expand array if i exceeds max range
			expandArray(i / 32 + 1);
		}
		if (i < 0) return; // just return and do nothing if i < 0
		
		if (!get(i)) { // if this number is not set before
			number++;
			int p1 = i / 32;
			int p2 = i % 32;
			int num = ints[p1];
			num = num | (1 << p2);
			ints[p1] = num;
		}
	}

	/**
	 * Clear the bit at position i.
	 * @param i A int that indicates the number needed to clear
	 * @return no return
	 */
	@Override
	public void clear(int i) {
		if (i >= curSize * 32 || i < 0) { 
			return; // do nothing if i < 0 or exceed max range
		}
		
		if (get(i)) { // if the number is not cleared before
			number--;
			int p1 = i / 32;
			int p2 = i % 32;
			int num = ints[p1];
			num = num & (~(1 << p2));
			ints[p1] = num;
		}
	}

	/**
	* Set the bits in the argument BitVector b.
	* @param b A BitVector that needs to be copied
	* @return no return
	*/
	@Override
	public void copy(IBitVector b) {
		Iterator<Integer> it = b.iterator(); // use iterator
		while (it.hasAnotherElement())
			this.set(it.nextElement());
	}

	/**
	 * Determine the number of non-zero bits in the BitVector.
	 * @param no parameters
	 * @return the number of non-zero bits
	 */
	@Override
	public int size() {
		return number;
	}

	/**
	 * Iterator over the Integer values represented by this BitVector.
	 * @param no parameters
	 * @return a iterator of this bitVector
	 */
	@Override
   	public Iterator<Integer> iterator(){
		
		return new BitIterator();
	}
	
	/**
	* A iterator that iterates integer values in the bitVector
	*/
	private class BitIterator implements Iterator<Integer> {
		private int current = -1; // current integer
		private int curSize = 0; // current number of integer that have been visited
		
		/**
		 * Check if there are more elements
		 * @param no parameters
		 * @return true if there is another integer in the bitVector
		 */
		@Override
		public boolean hasAnotherElement() {
			return curSize < BitVector.this.size();
		}

		/**
		 * Return the next element
		 * @param no parameters
		 * @return a Integer that presents the next element in the bitVector
		 */
		@Override
		public Integer nextElement() {
			if (!hasAnotherElement()) { 
				throw new NoSuchElementException();
			}
			else {
				current++;
				while (!BitVector.this.get(current)) {
					current++;
				}
				curSize++;
			}
			return current;
		}
	}

}
