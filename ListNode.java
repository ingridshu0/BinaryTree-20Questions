/**
 * @author Ingrid Shu
 * 
 * ListNode
 */

package BinaryTree;

public class ListNode<E> {
	
	private E item;
	private ListNode<E> next;
	
	/**
	 * Default constructor
	 * Next pointer set to null
	 * 
	 * @param i
	 */
	public ListNode(E i)
	{
		item = i;
		next = null;
	}
	
	/**
	 * Constructor
	 * 
	 * @param i item
	 * @param n next ListNode
	 */
	public ListNode(E i, ListNode<E> n)
	{
		item = i;
		next = n;
	}
	
	
	/**
	 * Accessor for item
	 * 
	 * @return item
	 */
	public E getItem()
	{
		return item;
	}
	
	
	/**
	 * Accessor
	 * 
	 * @return next ListNode
	 */
	public ListNode<E> getNext()
	{
		return next;
	}
	
	
	/**
	 * Modifier
	 * 
	 * @param i item
	 */
	public void setItem(E i)
	{
		item = i;
	}
	
	
	/**
	 * Modifier
	 * 
	 * @param n ListNode
	 */
	public void setNext(ListNode<E> n)
	{
		next = n;
	}
	
	
	/**
	 * @return string representation of the item in the ListNode
	 */
	public String toString()
	{
		String s = item.toString();
		
		return s;
	}

}
