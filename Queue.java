/**
 * @author Ingrid Shu
 * 
 * Queue- FIFO
 */

//package BinaryTree;

public interface Queue<E> {
	
	/**
	 * Add object to queue (end)
	 * @param item to add
	 */
	public void offer(E item);
	
	/**
	 * Remove object from head of queue
	 * @return object removed from head of queue
	 */
	public E poll();
	
	/**
	 * Return, but does not remove, the head item
	 * @return item at head
	 */
	public E peek();
	
	/**
	 * Return whether or not list is empty
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty();

}
