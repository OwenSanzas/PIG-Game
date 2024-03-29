import java.util.Random;
import java.util.Scanner;

public class GameControl {
	
	/**
	 * Computer player
	 */
	Computer computer;
	
	/**
	 * Human player
	 */
	Human human;
	
	/**
	 * A random number generator to be used for returning random dice result (1-6) for both computer and human player
	 */
	Random random = new Random();


	/**
	 * The main method just creates a GameControl object and calls its run method
	 * @param args not used
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Welcome to Pig!");
		
		GameControl gc = new GameControl();
		while (true) {
			gc.run(sc);
			System.out.println("--------------------");
			System.out.println("Do you want to play again?");
			
			boolean check = gc.askYesNo(sc);
			if (!check) {
				System.out.println("Goodbye!");
				sc.close();
				break;
			}
		}
	}
	
	/**
     * Calls methods to perform each of the following actions:
     * - Ask user to input the name for human player, and print welcome with the name
     * - Create the players (one human and one computer)
     * - Control the play of the game
     * - Print the final results
	 * @param sc to use for getting user input
	 */
	public void run(Scanner sc) {
		// initialize the game:
		System.out.println("Please input your name");
		String name = sc.next();
		System.out.println("Welcome " + name);

		// create the player:
		createPlayers(name);

		// set scores:
		human.setScore(0);
		computer.setScore(0);

		// run the game:
		while (true) {
			//computer move
			int temp_c = computer.move(human, random);
			System.out.println("Computer's score in this round: " + temp_c);
			System.out.println("Computer's total score is: " + computer.getScore() + "\n");

			//human move
			int temp_h = human.move(computer, random, sc);
			System.out.println(name + "\'s score in this round: " + temp_h);
			System.out.println("Human's total score is: " + human.getScore() + "\n");

			//check the winning status, print results, and print winner
			if (checkWinningStatus() == true) {
				printResults();
				printWinner();
				break;
			}

		}
	}
	/**
	 * Get a random number from [1, 6].
	 * @return the random number
	 */
	public int getRandom() {
		return this.random.nextInt(6)+1;
	}

	/**
     * Creates one human player with the given humanName, and one computer player with a name.
     * @param humanName for human player
     */
	public void createPlayers(String humanName) {
		human = new Human(humanName);
		computer = new Computer();
	}
	
	/**
     * Checks if a winning status has been achieved
     * @return true if one player has won the game
     */
	public boolean checkWinningStatus() {
		return human.getScore() != computer.getScore() && (human.getScore() >= 50 || computer.getScore() >= 50);
	}
	/**
	 * Prints the final scores of the human player and computer player
	 */
	public void printResults() {
		System.out.println("Human gets " + human.getScore());
		System.out.println("Computer gets " + computer.getScore());
	}
	
	/**
     * Determines who won the game, and prints the results
     */
	public void printWinner() {
		if (human.getScore() > computer.getScore())
			System.out.println("Human wins!");
		else
			System.out.println("Computer wins!");
	}
	
	/**
	 * If the user responds a string starting with "y" or "Y", the function returns True. 
	 * If the  user responds a string starting with "n" or "N", the function returns False. 
	 * Any other response will cause the question to be repeated until the user provides an acceptable response. 
	 * @param sc to use for getting user input
	 * @return true if user responds with "y" or "Y"
	 */
	public boolean askYesNo(Scanner sc) {
		while(true) {
			System.out.println("Do you want to play again?");
			String response = sc.next();
			response = response.trim(); //clear the whitespace
			char ch = response.charAt(0); //locate the char at 0th
			if (ch == 'y' || ch == 'Y') {
				return true;
			}
			if (ch == 'n' || ch == 'N') {
				return false;
			}
		}
	}


}
