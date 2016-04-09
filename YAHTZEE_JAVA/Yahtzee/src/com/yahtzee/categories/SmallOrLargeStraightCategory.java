package com.yahtzee.categories;

import java.util.Collections;
import java.util.List;
/***
 * For small straight, firstValueStraight = 1
 * For large straight, firstValueStraight = 2
 */
public class SmallOrLargeStraightCategory implements ICategory {

	private int firstValueStraight;
	public SmallOrLargeStraightCategory(int firstValueStraight) {
		this.firstValueStraight = firstValueStraight;
	}
	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		//doing ascending sort for this method
		Collections.sort(listDiceValues);
		for (Integer diceValue : listDiceValues) {
			if (diceValue != firstValueStraight++){
				return 0;
			}
			score += diceValue;
		}
		return score;
	}

}
