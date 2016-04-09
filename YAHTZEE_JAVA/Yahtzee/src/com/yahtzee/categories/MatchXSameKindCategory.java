package com.yahtzee.categories;

import java.util.List;

import com.yahtzee.Utility;
/***
 * Three, Four etc. of a kind Category. Also matches Yahtzee (6 of a kind)
 *
 */
public class MatchXSameKindCategory implements ICategory {

	private int matchN;
	public MatchXSameKindCategory(int matchN) {
		this.matchN = matchN;
	}
	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		score = Utility.GetSumRepeatedElements(listDiceValues, matchN, 
				false, false);
		
		//Yahtzee
		if (matchN == 5 && score > 0) {
			score = 50;
		}
		return score;
	}

}
