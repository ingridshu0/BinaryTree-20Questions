package BinaryTree;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * PreOrderIterator<E> iterates from root to left to right
 * 
 * @author ingrid
 */
public class PreOrderIterator<E> implements Iterator<E>
{
	
	private Queue<E> q = new LinkedList<E>();
	
	public PreOrderIterator(BinaryTree<E> tree)
	{
		fill(tree);
	}
	
	
	/**
	 * fill in order of: root, left, right
	 * @param head
	 */
	private void fill(BinaryTree<E> tree) {
		if(tree.isLeaf())
			q.offer(tree.value());
		
		else
		{			
			// root
			q.offer(tree.value());
			
			// left
			if(tree.left != null)
				fill(tree.left);
			
			// right
			if(tree.right != null)
				fill(tree.right);
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
