/**
 * @author Ingrid Shu
 * 
 * Stack- LIFO
 */

package BinaryTree;

public interface Stack<E>
{	
	/**
	 * Return, but does not remove, the head item
	 * @return item at head
	 */
	public E peek();
	
	/**
	 * Remove and return object from top of stack
	 * @return object removed from stack
	 */
	public E pop();
	
	/**
	 * Add object to stack (first)
	 * @param item to add
	 */
	public void push(E item);
	
	/**
	 * Return whether or not list is empty
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty();

}
