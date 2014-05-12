/**
 * 
 */
package roulette;

/**
 * @author connorhollenbeck
 *
 */
public class ThreeInARowBet extends Bet {

	/**
	 * @param description
	 * @param payout
	 */
	public ThreeInARowBet(String description, int payout) {
		super(description, payout);
	}

	/* (non-Javadoc)
	 * @see roulette.Bet#determineWin(int, int)
	 */
	@Override
	public boolean determineWin(String whichBet, Wheel wheel) {
		int start = Integer.parseInt(whichBet);
		return (start <= wheel.getNumber() && wheel.getNumber() < start + 3);

	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		String result = "" + ConsoleReader.promptRange(
				"Enter first of three consecutive numbers", 1, 34);
		System.out.println();
		return result;
	}

}
