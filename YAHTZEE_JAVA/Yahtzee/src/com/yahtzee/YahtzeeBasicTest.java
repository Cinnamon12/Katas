package com.yahtzee;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class YahtzeeBasicTest {
	MainClass mc = new MainClass();

	@Test
	public void testGetScoreForOnes() {
		int score = 1;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.five);
		listDice.add(Dice.two);
		listDice.add(Dice.six);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.ones));

		score = 4;
		assertEquals(score, mc.getScore(listDice, CategoryEnum.twos));
	}

	@Test
	public void testGetScoreForThrees() {
		int score = 6;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.three);
		listDice.add(Dice.two);
		listDice.add(Dice.two);
		listDice.add(Dice.five);
		listDice.add(Dice.three);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.threes));
	}

	@Test
	public void testGetScoreForFours() {
		int score = 16;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		listDice.add(Dice.five);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fours));
	}

	@Test
	public void testGetScoreForFives() {
		int score = 25;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.five);
		listDice.add(Dice.five);
		listDice.add(Dice.five);
		listDice.add(Dice.five);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fives));
	}

	@Test
	public void testGetScoreForSixes() {
		int score = 12;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.six);
		listDice.add(Dice.one);
		listDice.add(Dice.six);
		listDice.add(Dice.five);
		listDice.add(Dice.two);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.sixes));
	}

	@Test
	public void testGetScoreForChance() {
		int score = 20;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.five);
		listDice.add(Dice.one);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.two);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.chance));
	}

	@Test
	public void testGetScoreForYahtzee() {
		int score = 50;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.yahtzee));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		listDice.add(Dice.six);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.yahtzee));
	}

	@Test
	public void testGetScoreForPair() {
		int score = 8;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.pair));
	}

	@Test
	public void testGetScoreForTwoPairs() {
		int score = 8;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.two);
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.twopair));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.twopair));
	}

	@Test
	public void testGetScoreForThreeOfAKind() {
		int score = 9;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.threeOfAKind));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.threeOfAKind));
	}

	@Test
	public void testGetScoreForFourOfAKind() {
		int score = 12;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.three);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fourOfAKind));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fourOfAKind));
	}

	@Test
	public void testGetScoreForSmallStraight() {
		int score = 15;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.smallStraight));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.six);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.smallStraight));
	}

	@Test
	public void testGetScoreForLargeStraight() {
		int score = 20;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.six);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.largeStraight));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.one);
		listDice.add(Dice.two);
		listDice.add(Dice.three);
		listDice.add(Dice.four);
		listDice.add(Dice.five);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.largeStraight));
	}

	@Test
	public void testGetScoreForFullHouse() {
		int score = 7;
		List<Dice> listDice = new LinkedList<Dice>();
		listDice.add(Dice.two);
		listDice.add(Dice.two);
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		listDice.add(Dice.one);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fullHouse));

		score = 0;
		listDice = new LinkedList<Dice>();
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		listDice.add(Dice.four);
		assertEquals(score, mc.getScore(listDice, CategoryEnum.fullHouse));
	}

}