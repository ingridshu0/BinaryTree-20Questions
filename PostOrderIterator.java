//package BinaryTree;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * PostOrderIterator<E> iterates from left to right to root
 * 
 * @author ingrid
 */
public class PostOrderIterator<E> implements Iterator<E>
{
	
	private Queue<E> q = new LinkedList<E>();
	
	public PostOrderIterator(BinaryTree<E> tree)
	{
		fill(tree);
	}
	
	
	/**
	 * fill in order of: left, right, root
	 * @param head
	 */
	private void fill(BinaryTree<E> tree) {
		if(tree.isLeaf())
			q.offer(tree.value());
		
		else
		{			
			// left
			if(tree.left != null)
				fill(tree.left);
			
			// right
			if(tree.right != null)
				fill(tree.right);
			
			// root
			q.offer(tree.value());
		}
	}



	/**
	 * @return whether there are additional items in the queue
	 */
	public boolean hasNext() {
		if(q.isEmpty())
			return false;
		
		return true;
	}

	/**
	 * @return value at next index
	 */
	public E next() {
		if(hasNext())
			// returns obj at head of queue (first element)
			return q.poll();
	
		throw new NoSuchElementException();
	}

	/**
	 * not required
	 */
	public void remove() {
		
		
	}

}
