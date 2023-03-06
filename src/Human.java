
import java.util.Random;
import java.util.Scanner;

public class Human {
	
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * The score of the current player
	 */
	private int score = 0;
	
	
	/**
	 * Constructs a human player with the given name
	 * @param name of human
	 */
	public Human(String name) {
		this.name = name;
	}

	/**
	 * Controls human player to roll the dice, and prints the related information for each roll.
	 * First of all, this method will automatically roll one time for the human player, 
	 * if the result is 6, the player will have no right to roll again and this method should return 0; 
	 * else, this roll will be added to the total score for this turn.
	 * User should answer Y or N (y or n) to determine whether they want to roll the dice again 
	 * or stop with the current score.
	 * 
	 * This method will also update the human's total score.
	 * -- You can either add the total of all the rolls to the human's total score, within this move method
	 * e.g. this.score += scoreOneRound;
	 *  
	 * -- or you can call the setScore method from outside of this class, after calling this move method 
	 * e.g. int scoreOneRound = human.move(computer, random, sc);
	 *      human.setScore(scoreOneRound + human.getScore());
	 * 
	 * @param computer player
	 * @param random number generator
	 * @param sc to get input from user
	 * @return the score this round (for example, 
	 * 1. the player rolls: 2, 6, then this method should return 0
	 * 2. the player rolls: 5, 5, 2, then this method should return 12
	 * )
	 */
	public int move(Computer computer, Random random, Scanner sc) {
		GameControl gameControl = new GameControl();

		int scoreThisRound = 0;

		while (true) {
			int currentRoll = gameControl.getRandom();
			scoreThisRound += currentRoll;
			System.out.println(this.name + "\'s roll: " + currentRoll);
			if (currentRoll == 6) {
				// is this roll is 6, then the score of this round will be 0
				this.score += 0;
				return 0;
			} else if (this.askYesOrNo(sc)) {
				continue;
			} else if (!this.askYesOrNo(sc)) {
				this.score += scoreThisRound;
				return scoreThisRound;
			}
		}
	}
	/**
	 * Any response that begins with ‘y’ (capital or lowercase) should play again
	 * Any response that begins with ‘n’ (capital or lowercase) means the user wants to exit
	 * @param sc is a scanner to get the input
	 * @return true if it begins with 'y' or 'Y' and No with 'n' or 'N'
	 */
	public boolean askYesOrNo (Scanner sc) {
		while(true) {
			System.out.println("Do you want to roll again?");
			String answer = sc.next();
			answer = answer.trim(); //clear the white space
			char startChar = answer.charAt(0); //get the 0th element of the string
			if (startChar == 'y' || startChar == 'Y') {
				return true;
			} else if (startChar == 'n' || startChar == 'N') {
				return false;
			} else {
				continue;
			}
		}
	}
	
	/**
	 * Get the name of human
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the score of human
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Set the score of human
	 * @param score is the score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
}
