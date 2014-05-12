package roulette;

public class SingleNumberBet extends Bet {

	public SingleNumberBet(String description, int payout) {
		super(description, payout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean determineWin(String whichBet, Wheel wheel) {
		String number = "" + wheel.getNumber();
		return whichBet.equals(number);
	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		String result = ""
				+ ConsoleReader.promptRange(
						"Enter a number", 1, 34);
		System.out.println();
		return result;
	}

}
