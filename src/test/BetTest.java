package test;

import static org.junit.Assert.*;

import org.junit.Test;


import roulette.BlackRedBet;
import roulette.EvenOddBet;
import roulette.HighLowBet;
import roulette.SingleNumberBet;
import roulette.ThreeInARowBet;
import roulette.TwoInARowBet;
import roulette.Wheel;

/**
 * Test the Bet class.
 * 
 * @author Robert C. Duvall
 */
public class BetTest {

	Wheel wheel = new Wheel();
	Wheel clone = wheel.clone(23);
	
	@Test
	public void testBlackRedBet() {
		BlackRedBet b = new BlackRedBet("Bet", 1);
		String whichBet = "red";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "black";
		assertEquals(b.determineWin(whichBet, clone), false);
		
		
	}
	
	@Test
	public void testEvenOddBet() {
		EvenOddBet b = new EvenOddBet("Bet", 1);
		String whichBet = "odd";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "even";
		assertEquals(b.determineWin(whichBet, clone), false);
		
	}
	
	@Test
	public void testThreeInARowBet() {
		ThreeInARowBet b = new ThreeInARowBet("Bet", 11);
		String whichBet = "21";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 11);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);
		
	}
	
	@Test
	public void testTwoInARowBet() {
		TwoInARowBet b = new TwoInARowBet("Bet", 17);
		String whichBet = "22";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 17);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);
		
	}
	
	@Test
	public void testHighLowBet() {
		HighLowBet b = new HighLowBet("Bet", 1);
		String whichBet = "hi";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 1);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "low";
		assertEquals(b.determineWin(whichBet, clone), false);
		
	}
	
	@Test
	public void testSingleNumberBet() {
		SingleNumberBet b = new SingleNumberBet("Bet", 35);
		String whichBet = "23";
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 35);
		assertEquals(b.determineWin(whichBet, clone), true);
		whichBet = "20";
		assertEquals(b.determineWin(whichBet, clone), false);
		
	}
}
