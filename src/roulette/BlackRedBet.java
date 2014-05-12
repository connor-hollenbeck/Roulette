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
public class BlackRedBet extends Bet {

	/**
	 * @param description
	 * @param payout
	 */
	public BlackRedBet(String description, int payout) {
		super(description, payout);
		
	}


	@Override
	public boolean determineWin(String whichBet, Wheel wheel) {
		String color = wheel.getColor();
		return color.equals(whichBet);
	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add("black");
		choices.add("red");
		System.out.println();
		return ConsoleReader.promptOneOf("Please bet", choices);
	}

}
