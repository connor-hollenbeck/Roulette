package roulette;

public class TwoInARowBet extends Bet {

	public TwoInARowBet(String description, int payout) {
		super(description, payout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean determineWin(String whichBet, Wheel wheel) {
		int start = Integer.parseInt(whichBet);
		return (start <= wheel.getNumber() && wheel.getNumber() < start + 2);
	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		String result = ""
				+ ConsoleReader.promptRange(
						"Enter first of two consecutive numbers", 1, 34);
		System.out.println();
		return result;
	}

}
