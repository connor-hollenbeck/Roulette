package test;

import static org.junit.Assert.*;

import org.junit.Test;

import roulette.Gambler;
import roulette.Game;
import roulette.Wheel;

public class GameAndWheelTest {
	
	Gambler dude = new Gambler("The Dude", 5000);
	Wheel wheel = new Wheel();
	Game game = new Game();
	Wheel clone = wheel.clone(1);
	
	/**
	 * For the first prompt, enter 1 for the test to work
	 */
	@Test
	public void testPlay() {
		assertEquals("Roulette", game.getName());
		int bet = game.promptForBet();
		assertEquals(0, bet);
		game.play(dude);
		game.play(dude);
	}
	
	@Test
	public void testWheelGetters() {
		assertEquals(1, clone.getNumber());
		assertEquals("red", clone.getColor());
		wheel.spin();
		assertEquals(1, wheel.getNumSpins());
	}

}
