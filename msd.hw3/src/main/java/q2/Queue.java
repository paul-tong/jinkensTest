package q2;

import java.util.ArrayList;

/**
 * A queue that adapts ArrayList
 * @author peng
 * @param <T>
 */
@SuppressWarnings("serial")
public class Queue<T> extends ArrayList<T> implements IQueue<T>{

	/**
	* add an element to the head of the queue
	* @param the element needs to be added
	* @return true if add successfully
	*/
	@Override
	public boolean add(T t) {
		return super.add(t);
	}

	/**
	* remove an element from the end of the queue.
	* @param no paremeters
	* @return return the first element, returns null if queue is empty
	*/
	@Override
	public T remove() {
		return (super.size() == 0)? null : super.remove(0);
	}

	/**
	* returns the head of the queue.
	* @param no parameters
	* @return return the first element, returns null if queue is empty
	*/
	@Override
	public T peek() {
		return (super.size() == 0)? null : super.get(0);
	}

}
