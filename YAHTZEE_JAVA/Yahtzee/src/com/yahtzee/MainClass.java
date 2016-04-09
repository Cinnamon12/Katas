package com.yahtzee;

import java.util.LinkedList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
//		List<Dice> listDice = new LinkedList<Dice>();
//		listDice.add(Dice.six);
//		listDice.add(Dice.three);
//		listDice.add(Dice.four);
//		listDice.add(Dice.five);
//		listDice.add(Dice.two);
		
//		int score = new MainClass().getScore(listDice, CategoryEnum.largeStraight);
//		System.out.println(score);

	}
	
	public int getScore (List<Dice> listDice, CategoryEnum category){
		if(listDice.size() != 5){
			throw new IllegalArgumentException("Number of Dice values not equal to 5");
		}
		List<Integer> listDiceValues = getDiceValues(listDice);
		return category.evaluate(listDiceValues);
	}
	private List<Integer> getDiceValues (List<Dice> listDice) {
		List<Integer> listDiceValues = new LinkedList<Integer>();
		for (Dice dice : listDice) {
			listDiceValues.add(dice.diceValue);
		}
		return listDiceValues;
	}

}
