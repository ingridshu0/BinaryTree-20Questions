package BinaryTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<E> implements Iterator<E>
{	
	private ListNode<E> cur;
	
	public LinkedListIterator(ListNode<E> head)
	{
		// keep track of current (index variable)
		cur = head;
		
	}
	
	public boolean hasNext()
	{
		return cur != null;
	}
	
	public E next()
	{
		if(hasNext() == false)
		{
			throw new NoSuchElementException();
		}
		
		// get item
		E item = cur.getItem();
		
		// increment cur
		cur = cur.getNext();
		
		// return item
		return item;
	}
	
	public void remove()
	{
		
	}
}
