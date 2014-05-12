/**
 * 
 */
package roulette;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author connorhollenbeck
 *
 */
public class EvenOddBet extends Bet {

	/**
	 * @param description
	 * @param payout
	 */
	public EvenOddBet(String description, int payout) {
		super(description, payout);

	}

	/* (non-Javadoc)
	 * @see roulette.Bet#determineWin(String, Wheel)
	 */
	@Override
	public boolean determineWin (String whichBet, Wheel wheel) {
		int number = wheel.getNumber();
		return (number % 2 == 0 && (number != 0) && whichBet.equals("even"))
				|| (number % 2 == 1 && whichBet.equals("odd"));
	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add("odd");
		choices.add("even");
		System.out.println();
		return ConsoleReader.promptOneOf("Please bet", choices);
	}

}
