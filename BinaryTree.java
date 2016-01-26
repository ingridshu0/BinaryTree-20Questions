/**
 * BINARY TREE
 * 
 * API https://docs.google.com/a/pingry.org/document/d/10h_Go6vTp7mxtVwmiCmiT6cMa2Uooe6Hz4LbXrIlvG8/edit?usp=drive_web
 * 
 */

package BinaryTree;
import java.lang.Math;
import java.util.Iterator;

/**
 * BinaryTree<E>
 * 
 * @author ingrid
 */
public class BinaryTree<E> implements Iterable<E> {
	
	//
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;
	
	
	/**
	 * Constructor
	 * 
	 * @param v
	 * @param l
	 * @param r
	 */
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}

	
	/**
	 * Constructor
	 * Sets value equal to v, left and right are null
	 * 
	 * @param v
	 */
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	
	/**
	 * Default Constructor
	 * 
	 * Value, left, and right are all null
	 */
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}
	
	// Accessors:
	/**
	 * returns BinaryTree to the left of this
	 * 
	 * @return BinaryTree to the left of this
	 */
	public BinaryTree<E> left()
	{
		return left;
	}
	
	
	/**
	 * returns BinaryTree to the right of this
	 * 
	 * @return BinaryTree to the right of this
	 */
	public BinaryTree<E> right()
	{
		return right;
	}
	
	
	/**
	 * returns value of leaf
	 * 
	 * @return value of given leaf
	 */
	public E value()
	{
		return value;
	}

	// Modifiers:
	/**
	 * sets left to new node
	 * @param node
	 */
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	
	
	/**
	 * 
	 * @param val
	 */
	public void setValue(E val)
	{
		value = val;
	}

	
	/**
	 * Return true if node does not have any children
	 * @return
	 */
	public boolean isLeaf()
	{
		return right == null && left == null;
	}

	
	/**
	 * Return number of descendants of node, including current node
	 * @return
	 */
	public int size()
	{
		// base case
		if(isLeaf())
			return 1;
		else if(right == null && left != null)
			return 1 + left.size();
		else if (right !=  null && left == null)
			return 1 + right.size();
		
		// both aren't null
		else
			return 1 + right.size() + left.size();		
	}

	
	// Iterators:
	/**
	 * same thing as InOrderIterator
	 * 
	 * @return iteration of tree from left to root to right
	 */
	@SuppressWarnings("unchecked")
	public Iterator<E> iterator()
	{
		return new InOrderIterator(this);
	}
	
	
	/**
	 * iterates through tree from root to left to right
	 *  
	 * @return iteration of tree in order from root, left, right
	 */
	@SuppressWarnings("unchecked")
	public Iterator<E> preorderIterator()
	{
		return new PreOrderIterator(this);
	}
	
	
	/**
	 * iterates through tree from left to root to right
	 * 
	 * @return iteration of tree in order from left to root to right
	 */
	@SuppressWarnings("unchecked")
	public Iterator<E> inorderIterator()
	{
		return new InOrderIterator(this);
	}
	
	
	/**
	 * iterates through tree from left to right to root
	 * 
	 * @return iteration of tree in order from left, right, root
	 */
	@SuppressWarnings( "unchecked" )
	public Iterator<E> postorderIterator()
	{
		return new PostOrderIterator(this);
	}
	

	/**
	 * returns String representation of the tree
	 * 
	 * @return String representation of the tree
	 */
	public String toString()
	{		
		String s = "";
		if(isLeaf())
		{
			s += value;
			return s;
		}
		s += value;
		s += "[";
		if(left != null)
		{
			s += left.toString();
		}
		s += "]";
		s += "[";
		if(right != null)
		{
			s += right.toString();
		}
		s += "]";
		return s;
		
	}

	
	/**
	 * Return the maximum path length to a descendant
	 * 
	 * @return maximum path length to descendant
	 */
	public int height()
	{
		int h = 0;
		
		// base case
		if(isLeaf())
			return 1;
		
		// if right or left are null
		else if(right == null)
			h += 1 + left.height();
		else if(left == null)
			h += 1 + right.height();
		
		// takes node with greater height
		else
			h += 1 + Math.max(left.height(), right.height());
		
		return h;
		
	}


	/**
	 * Return true if adding a node to tree would increase its height
	 * @return whether the tree is full
	 */
	public boolean isFull()
	{
		if(isLeaf())
			return true;
		
		// cannot be full if only one branch is null
		else if(right == null || left == null)
			return false;
		
		else
		{
			if(right.height() == left.height())
				return right.isFull() && left.isFull();
			
			// uneven
			else
				return false;
		}
		
	}

	
	/**
	 * Return true if tree has minimal height and any holes in the tree appear in the last level to the right
	 * 
	 * @return if tree is complete
	 */
	public boolean isComplete()
	{		
		if(isLeaf())
			return true;
	
		// heights of right and left nodes must have a difference of 1
		else if(Math.abs(right.height() - left.height()) <= 1)
		{
			// hole in right node is okay
			if(left.isComplete() && right.isFull())
				return left.isComplete() && right.isComplete();
			
			// hole in left node is not okay
			else if(left.isFull() && right.isComplete() && left.isComplete() == false)
				return false;
		}
		
		// difference of heights is greater than 2 means that the tree cannot be complete
		return false;
	}

	
	/**
	 * Return true if the difference of heights of subtrees at every node is no greater than one
	 * 
	 * @return if the tree is balanced
	 */
	public boolean isBalanced()
	{
		if(isLeaf())
			return true;
		
		else if(right == null)
		{
			if(left.isLeaf())
				return true;
			return false;
		}
		
		else if(left == null)
		{
			if(right.isLeaf())
				return true;
			return false;
		}
		
		else if(Math.abs(right.height() - left.height()) <= 1)
			return right.isBalanced() && left.isBalanced();
		
		// difference in heights is greater than 1
		return false;
	}
}
