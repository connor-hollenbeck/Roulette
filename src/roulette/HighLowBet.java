package roulette;

import java.util.Set;
import java.util.TreeSet;

public class HighLowBet extends Bet {

	public HighLowBet(String description, int payout) {
		super(description, payout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean determineWin(String whichBet, Wheel wheel) {
		int number = wheel.getNumber();
		return (number > 18 && whichBet.equals("hi"))
				|| (number <= 18 && whichBet.equals("low"));
	}
	
	@Override
	public String placeBetPrompt (int whichBet) {
		Set<String> choices = new TreeSet<String>();
		choices.add("hi");
		choices.add("low");
		System.out.println();
		return ConsoleReader.promptOneOf("Please bet", choices);
	}

}
