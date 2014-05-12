package roulette;

/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
	// name of the game
	private static final String DEFAULT_NAME = "Roulette";

	private Wheel myWheel;
	private Bet[] myPossibleBets = {
		new BlackRedBet("Red or Black", 1),
		new EvenOddBet("Odd or Even", 1),
		new ThreeInARowBet("Three in a Row", 11),
		new HighLowBet("High or Low", 1),
		new SingleNumberBet("Single Number", 35),
		new TwoInARowBet("Two in a row", 17)
	};

	/**
	 * Construct the game.
	 */
	public Game() {
		myWheel = new Wheel();
	}

	/**
	 * @return name of the game
	 */
	public String getName() {
		return DEFAULT_NAME;
	}

	/**
	 * Play a round of this game.
	 * 
	 * For Roulette, this means prompting the player to make a bet, spinning the
	 * roulette wheel, and then verifying that the bet is won or lost.
	 * 
	 * @param player
	 *            one that wants to play a round of the game
	 * 
	 */
	public void play(Gambler player) {
		int amount = ConsoleReader.promptRange("How much do you want to bet",
				0, player.getBankroll());
		int whichBet = promptForBet();
		String betChoice = myPossibleBets[whichBet].placeBetPrompt(whichBet);

		System.out.print("Spinning ...");
		myWheel.spin();
		System.out.println("Dropped into " + myWheel.getColor() + " "
				+ myWheel.getNumber());

		if (myPossibleBets[whichBet].determineWin(betChoice, myWheel)) {
			System.out.println("*** Congratulations :) You win ***");
			amount *= myPossibleBets[whichBet].getPayout();
		} else {
			System.out.println("*** Sorry :( You lose ***");
			amount *= -1;
		}
		player.updateBankroll(amount);
	}

	/**
	 * Prompt the user to make a bet from a menu of choices.
	 */
	public int promptForBet() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println((k + 1) + ") "
					+ myPossibleBets[k].getDescription());
		}

		return ConsoleReader.promptRange("Please make a choice", 1,
				myPossibleBets.length) - 1;
	}
}
