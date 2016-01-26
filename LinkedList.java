/**
 * @author Ingrid Shu
 * 
 * LinkedList Assignment
 * 11/29/2015
 * 
 * Notes- 
 * 1. to compare 2 object values, use .equals() / == is for memory addresses or primitive types
 * 2. traverse through a LinkedList using a for loop for each ListNode starting from head
 * 3. Stack and Queue can only use the methods that they define (implementing)
 */

package BinaryTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>, Stack<E>, Queue<E> {
	
	private ListNode<E> head;
	private ListNode<E> tail;
	private int size;
	
	/**
	 * Default constructor
	 */
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	
	/**
	 * Constructor
	 * @param h
	 */
	public LinkedList(ListNode<E> h)
	{
		head = h;
		tail = h;
		size = 1;
	}
	
	
	/**
	 * Copy constructor
	 * 
	 * @param other
	 */
	public LinkedList(LinkedList<E> other)
	{
		head = other.getHead(other);
		tail = other.getTail(other);
		size = other.getSize(other);
	}
	
	
	/**
	 * Private accessor method for the head of a LinkedList
	 * 
	 * @param ll LinkedList
	 * @return head of ll
	 */
	private ListNode<E> getHead(LinkedList<E> ll)
	{
		return ll.head;
	}
	
	
	/**
	 * Private accessor method for the tail of a LinkedList
	 * 
	 * @param ll LinkedList
	 * @return tail of ll
	 */
	private ListNode<E> getTail(LinkedList<E> ll)
	{
		return ll.tail;
	}
	
	
	/**
	 * Private accessor method for the size of a LinkedList
	 * 
	 * @param ll LinkedList
	 * @return size of ll
	 */
	private int getSize(LinkedList<E> ll)
	{
		return ll.size;
	}
	
	
	/**
	 * Add object to the end of the list
	 * 
	 * @param o item to add
	 * @return if item was added
	 */
	public boolean add(E o)
	{
		add(size, o);
		
		if(tail.getItem().equals(o))
		{
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Add object to stack (first)
	 * 
	 * @param item to add
	 */
	public void push(E item)
	{
		add(0, item);
	}

	
	/**
	 * Add object to queue (end)
	 * 
	 * @param item to add
	 */
	public void offer(E item)
	{
		add(item);
	}

	
	/**
	 * Remove item and return whether or not object was removed
	 * 
	 * @param o object to remove
	 * @return true if object was found and removed, false if objected was not found
	 */
	public boolean remove(E o)
	{
		int counter = 0;
		
		for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
		{			
			// o at first index
			if(counter == 0)
			{
				if(cur.getItem().equals(o))
				{
					head = cur.getNext();
					size--;
					return true;
				}
			}
			
			// last index
			// cannot contain o, checked at previous index
			// o is not contained in this LinkedList
			if(counter == size - 1)
			{	
				return false;
			}
			 
			if(cur.getNext().getItem().equals(o))
			{				
				// o at second to last last index
				// must set tail to cur because cur.getNext().getNext() does not exist
				if(counter == size - 2)
				{
					cur.setNext(null);
					tail = cur;
					size--;
					return true;
				}
									
				// if the item contained in the next ListNode is o, the pointer from the current ListNode will be set to the the ListNode after the next ListNode
				cur.setNext(cur.getNext().getNext());
				size--;
				return true;
			}
			
			counter++;
		}
		
		return false;
	}

	
	/**
	 * Remove and return item at specified index
	 * Finds specified index (if it exists)
	 * If necessary, traverses through LinkedList
	 * 
	 * @param index to remove
	 * @return item removed
	 */
	public E remove(int index)
	{
		
		//index does exist
		if(index < size)
		{
			// first index
			if(index == 0)
			{
				return removeFirst();
			}
			
			// last index
			if(index == size - 1)
			{
				return removeLast();
			}
			
			// 0 < index < size - 2
			int counter = 0;
			E removed;
			
			for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
			{
				// when index has been found, saves the removed item, resets the pointer, decreases the size, and returns the removed item 
				if(counter == index - 1)
				{				
					removed = cur.getNext().getItem();
					cur.setNext(cur.getNext().getNext());
					size--;
					
					return removed;
				}
				
				counter++;
			}
		}
		
		// index does not exist
		throw new IndexOutOfBoundsException();
	}

	
	/**
	 * Remove and return first item in the list
	 * 
	 * @return removed item
	 */
	public E removeFirst()
	{
		if(head != null)
		{
			E removed = head.getItem();
			size--;
			
			head = head.getNext();
			return removed;
		}
		
		// head is null
		throw new NoSuchElementException();
	}

	
	/**
	 * Remove and return last item in the list
	 * 
	 * @return removed item
	 */
	public E removeLast()
	{
		if(tail != null)
		{
			//E removed = tail.getItem();
			int counter = 0;
			
			// go through LinkedList to set the second to last ListNode as the tail
			for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
			{
				if(counter == size - 2)
				{
					E removed = cur.getNext().getItem();
					tail = cur;
					cur.setNext(null);
					size--;
					return removed;
				}
				counter++;
			}
		}
		
		throw new NoSuchElementException();
	}
	
	
	/**
	 * Add object to front of list
	 * 
	 * @param item
	 */
	public void addFirst(E item)
	{
		add(0, item);
	}


	/**
	 * Add object to end of list
	 * 
	 * @param item
	 */
	public void addLast(E item)
	{
		add(item);
	}

	
	/**
	 * Return whether or not list contains specified object
	 * 
	 * @param o object to find
	 * @return whether or not o is present in the LinkedList
	 */
	public boolean contains(E o)
	{
		if(indexOf(o) >= 0)
		{
			return true;
		}
		
		return false;
	}

	
	/**
	 * Return size of the list
	 * 
	 * @return size of this LinkedList
	 */
	public int size()
	{
		return size;
	}

	
	/**
	 * Remove all items from the list
	 */
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}


	/**
	 * Return item at specified index
	 * If necessary, finds index
	 * Returns item at specified index
	 * 
	 * @param i index to find item of
	 * @return item found at index i
	 */
	public E get(int i)
	{
		System.out.println("i: " + i);
		System.out.println("size: " + size);
		// index does exist
		if(i < size)
		{
			// first index
			if(i == 0)
			{
				return head.getItem();
			}
			
			// last index
			else if(i == size - 1)
			{
				return tail.getItem();
			}
			
			else
			{
				int counter = 0;
				
				for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
				{
					// index found
					if(counter == i)
					{
						return cur.getItem();
					}
					
					counter++;
				}
			}
		}
		
		// index does not exist
		throw new IndexOutOfBoundsException();
	}

	
	/**
	 * Place object at specified location 
	 * If necessary, finds the index to be changed
	 * Stores item at that index
	 * Sets item at that index to parameter o
	 * Returns stored item
	 * 
	 * @param i index
	 * @param o object to be replaced with
	 * @return object that was replaced
	 */
	public E set(int i, E o)
	{
		// index does exist
		if(i < size)
		{
			E replaced;
			
			// first index
			if(i == 0)
			{
				replaced = head.getItem();
				head.setItem(o);
				
				return replaced;
			}
			
			// last index
			else if(i == size - 1)
			{
				replaced = tail.getItem();
				tail.setItem(o);
				
				return replaced;
			}
			
			else
			{
				int counter = 0;
				
				for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
				{
					if(counter == i)
					{
						replaced = cur.getItem();
						cur.setItem(o);
						
						return replaced;
					}
					
					counter++;
				}
			}
		}
		
		// index does not exist
		throw new IndexOutOfBoundsException();
	}
	

	/**
	 * Add object at specified location
	 * 
	 * @param index to add at
	 * @param i item to add	
	 */
	public void add(int index, E i)
	{
		// index does not exist
		if(index > size + 1)
		{
			throw new IndexOutOfBoundsException();
		}
		
		// index does exist
		ListNode<E> newNode = new ListNode<E>(i);
		
		// first index
		if(index == 0)
		{
			// new LinkedList
			if(size == 0)
			{
				head = newNode;
				tail = newNode;
				size++;
			}
			
			// adding to first index of existing LinkedList
			else
			{
				ListNode<E> tempNode = head;
				head = newNode;
				size++;
				head.setNext(tempNode);
			}
		}
		
		// any other index
		else
		{
			int counter = 0;
			
			for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
			{
				
				// resets pointers, increases size
				if(counter == index - 1)
				{
					newNode.setNext(cur.getNext());
					cur.setNext(newNode);
					size++;
					
					// last index- must reset tail pointer
					if(index == size - 1 || index == 0)
					{
						tail = newNode;
						tail.setNext(null);
					}
				}
				counter++;
			}
		}
	}

	
	/**
	 * Return index of the first instance of specified object
	 * 
	 * @param o item to look for
	 * @return the index of the item. if the return int is negative, o does not exist in the LinkedList
	 */
	public int indexOf(E o)
	{		

		// first index
		if(head.getItem().equals(o))
		{
			return 0;
		}
		
		// last index
		else if(tail.getItem().equals(o))
		{
			return size - 1;
		}
		
		// any other index
		else
		{
			int counter = 0;
			
			for(ListNode<E> cur = head; cur != null; cur = cur.getNext())
			{
				if(cur.getItem().equals(o))
				{
					return counter;
				}
				
				counter++;
			}
		}

		// does not exist
		return -1;
	}
	
	
	/**
	 * Remove object from head of queue
	 * 
	 * @return object removed from head of queue
	 */
	public E poll()
	{
		return removeFirst();
	}

	
	/**
	 * Remove and return object from top of stack
	 * 
	 * @return object removed from stack
	 */
	public E pop()
	{
		return removeFirst();
	}

	
	/**
	 * Return, but does not remove, the head item
	 * 
	 * @return item at head
	 */
	public E peek()
	{
		if(head != null)
			return head.getItem();
		
		return null; 
	}

	
	/**
	 * Return whether or not list is empty
	 * 
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		
		return false;
	}


	/**
	 * Create and return an iterator
	 * 
	 * @return iterator of this
	 */
	public Iterator<E> iterator()
	{
		return new LinkedListIterator<E>(head);
	}
	
	
	/**
	 * @return String representation of the items in the LinkedList
	 */
	public String toString()
	{
		String s = "";
				
		for(ListNode<E> i = head; i != null; i = i.getNext())
		{
			s += i.toString();
			s += ", ";
		}
		
		return s;
	}

}
