package com.yahtzee.categories;

import java.util.Collections;
import java.util.List;

public class PairCategory implements ICategory {

	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		Collections.sort(listDiceValues, Collections.reverseOrder());
		//assuming here that having more than 2 matching dice values
		//is fine. Player won't get 0 score for that 
		for (Integer diceValue : listDiceValues){
			int frequency = Collections.frequency(listDiceValues, diceValue);
			if (frequency >= 2) {
				score = diceValue * 2;
				break;
			}
		}
		return score;
	}

}
