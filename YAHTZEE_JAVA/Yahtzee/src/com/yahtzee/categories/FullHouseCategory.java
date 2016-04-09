package com.yahtzee.categories;

import java.util.List;

import com.yahtzee.Utility;

public class FullHouseCategory implements ICategory {

	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		int scoreSecond = 0;
		//first pair
		score = Utility.GetSumRepeatedElements(listDiceValues, 2, 
				false, true);
		//checking if a pair was not found
		if (score == 0){
			return 0;
		}
		//second pair. Adding new score to existing
		scoreSecond = Utility.GetSumRepeatedElements(listDiceValues, 3, 
				false, true);
		if (scoreSecond == 0) {
			return 0;
		}
		score += scoreSecond;
		return score;
	}

}
