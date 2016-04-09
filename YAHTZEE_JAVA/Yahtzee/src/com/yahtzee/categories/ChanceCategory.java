package com.yahtzee.categories;

import java.util.List;

public class ChanceCategory implements ICategory {

	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		for (Integer diceValue : listDiceValues) {
			score += diceValue;
		}
		return score;
	}

}
