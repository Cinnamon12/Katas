package com.yahtzee.categories;

import java.util.List;
/**
 * 
 * Implement ones, twos, .., sixes category. 
 * nValue determines which category
 *
 */
public class NsCategory implements ICategory {

	private int nValue;
	public NsCategory(int nValue) {
		this.nValue = nValue;
	}
	@Override
	public int getCategoryScore(List<Integer> listDiceValues) {
		int score = 0;
		for (Integer diceValue : listDiceValues){
			if (diceValue == nValue){
				score += nValue;
			}
		}		
		return score;
	}

}
