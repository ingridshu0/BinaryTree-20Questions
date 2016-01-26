// TODO TEST DIFFERENT CASES FOR ALL METHODS

//package BinaryTree;

/**
 * Runner class for BinaryTree<E>
 * @author ingrid
 *
 */
public class BinaryTreeRunner {
	
	public static void main(String[] args)
	{
		BinaryTree<String> c1 = new BinaryTree<String>("Left A");
		BinaryTree<String> c2 = new BinaryTree<String>("Right B");
		BinaryTree<String> c3 = new BinaryTree<String>("Left C");
		BinaryTree<String> c4 = new BinaryTree<String>("Right D");
		BinaryTree<String> c5 = new BinaryTree<String>("Left E");
		BinaryTree<String> c6 = new BinaryTree<String>("Right F");

		
		
		BinaryTree<String> b1 = new BinaryTree<String>("Left",c1,c2);
		BinaryTree<String> b2 = new BinaryTree<String>("Right",c3,c4);
		BinaryTree<String> head = new BinaryTree<String>("Top",b1,b2);
		
		// modifiers
		b2.setLeft(c5);
		b2.setRight(c6);
		c6.setValue("changed");
		
		System.out.println(head);
		
		// isLeaf()
		System.out.println("true: " + c6.isLeaf()); // true
		System.out.println("false: " + head.isLeaf()); // false
		
		// size()
		System.out.println(head.size()); // should return 7
		
		// height()
		System.out.println(head.height()); // should return 3
		
		// isFull()
		System.out.println(head.isFull()); // should return true
		
		// isComplete()
		System.out.println(head.isComplete()); // should return true
		
		// isBalanced()
		System.out.println(head.isBalanced()); // should return true
		
		System.out.println(head + "\n");
		
		// ITERATORS
		// InOrderIterator() and iterator(): left, root, right
		String s = "";
		
		for(String x : head)
			s += x;
		
		System.out.println(s);
		
	}

}
