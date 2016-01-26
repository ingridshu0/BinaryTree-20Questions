package TwentyQuestions;

import java.util.Scanner;

/**
 * TwentyQuestions Lab
 * "learns" through user's advice and updates tree accordingly
 * game continues if it guessed wrongly and was updated and terminates if it guessed correctly
 * DOES NOT save updates (fulfills minimum requirements)
 * 
 * note(s): everything commented out without a space (//System. . .) was used only for testing purposes and can be deleted; comments 
 * are denoted by // comment. also, it is much more difficult to taunt the user online than it is in person.
 * @author ingrid
 *
 */
public class TwentyQuestions {
	
	// yes = right, no = left
	private static BinaryTree<String> yesVal1 = new BinaryTree<String>("dog");
	private static BinaryTree<String> noVal1 = new BinaryTree<String>("pizza");
	private static BinaryTree<String> tree = new BinaryTree<String>("alive", noVal1, yesVal1);

	public static void main(String[] args)
	{
		
		System.out.println("TWENTY QUESTIONS");
		System.out.println("type 'yes' or 'no' to answer" + "\n");
		System.out.println("---first question--- ");
		
		playGame(tree);
	}
	
	
	/**
	 * plays game
	 * 
	 * @param node
	 */
	public static void playGame(BinaryTree<String> node)
	{
		String input;
		boolean answered = false;
		while(answered == false)
		{
			// ask question
			System.out.println("Is it " + node.value() + "?");
			
			// get response
			input = getInput();
			
			if(input.equals("yes"))
			{							
				// user answers yes, program offers answer (right LEAF)
				if(node.right().isLeaf())
				{					
					System.out.println("Is it " + node.right().value() + "?");
					String input1 = getInput();
					
					// correct answer
					if(input1.equals("yes"))
					{						
						System.out.println("\n" + "nice" + "\n" + "I win!!");
						
						// terminate game
						answered = true;
						break;
					}
					
					// incorrect answer + update
					else if(input1.equals("no"))
					{						
						updateRight(node);
						
						answered = true;
						
						// restart game
						System.out.println("\n" + "---okay... let's PLAY AGAIN!!!---");
						playGame(tree);
						
						answered = true;
					}
				}
				
				// program moves on to next question (right)
				else
				{					
					playGame(node.right());
					
					// necessary to prevent another iteration after recursive method above
					answered = true;
				}
			}
			
			// input is no
			else if(input.equals("no"))
			{						
				// user answers yes, program offers answer (left LEAF)
				if(node.left().isLeaf())
				{					
					System.out.println("Is it " + node.left().value() + "?");
					String input1 = getInput();
					
					// correct answer
					if(input1.equals("yes"))
					{						
						System.out.println("\n" + "nice" + "\n" + "I win!!");
						answered = true;
					}
					
					// incorrect answer + update
					else if(input1.equals("no"))
					{						
						updateLeft(node);
						
						answered = true;
						
						// restart game
						System.out.println("\n" + "---okay... let's PLAY AGAIN!!!---");
						playGame(tree);
						
						answered = true;
					}
				}
				
				// user answers yes, program moves on to next question (left)
				else
				{
					playGame(node.left());
					
					answered = true;
				}
			}
		}
	}
	
	
	/**
	 * helper method that returns a String version of the user's input
	 * @return String version of user's input
	 */
	private static String getInput()
	{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		return str;
	}
	
	
	/**
	 * helper method to update the right (yes) node
	 * @param node
	 */
	private static void updateRight(BinaryTree<String> node)
	{
		System.out.println("\n" + "---you win...---");
		System.out.println("what were you thinking of?");
		String userAnswer = getInput();
		BinaryTree<String> prevAnswer = new BinaryTree<String>(node.right().value());
		
		// update
		System.out.println("What's the difference?" + "\n" + "(1 word description)");
		String userQuestion = getInput();
		
		BinaryTree<String> newQ = new BinaryTree<String>(userQuestion);
		BinaryTree<String> newA = new BinaryTree<String>(userAnswer);
		
		node.setRight(newQ);
		newQ.setRight(newA);
		newQ.setLeft(prevAnswer);
		
		//System.out.println("UPDATED " + tree);
	}
	
	
	/**
	 * helper method to update the left (no) node
	 * 
	 * @param node
	 */
	private static void updateLeft(BinaryTree<String> node)
	{
		System.out.println("\n" + "---you win...---");
		System.out.println("what were you thinking of?");
		String userAnswer = getInput();
		BinaryTree<String> prevAnswer = new BinaryTree<String>(node.left().value());
		
		// update
		System.out.println("What's the difference?" + "\n" + "(1 word description)");
		String userQuestion = getInput();
		
		BinaryTree<String> newQ = new BinaryTree<String>(userQuestion);
		BinaryTree<String> newA = new BinaryTree<String>(userAnswer);
		
		node.setLeft(newQ);
		newQ.setRight(newA);
		newQ.setLeft(prevAnswer);
		
		//System.out.println("UPDATED " + tree);
	}
	
}
