package com.yahtzee;

import java.util.Collections;
import java.util.List;

public class Utility {
	/**
	 * 
	 * @param listDiceValues : list containing all dice values
	 * @param minNumberOfRepeats : Min Number of times a dice value is repeated
	 * @param isUpperLimitOnRepeats : If there's any upper limit of repetitions. Haven't used it
	 * @param truncateDiceValues : boolean, when a repeated dice value is found, if it's occurrences be removed from listDiceValues 
	 * @return
	 */
	public static int GetSumRepeatedElements(List<Integer> listDiceValues, int minNumberOfRepeats, boolean
			isUpperLimitOnRepeats, boolean truncateDiceValues){
		int score = 0;
		for (Integer diceValue : listDiceValues){
			int frequency = Collections.frequency(listDiceValues, diceValue);
			if ((isUpperLimitOnRepeats && frequency == minNumberOfRepeats) ||
					(!isUpperLimitOnRepeats && frequency >= minNumberOfRepeats)){
				score = diceValue * minNumberOfRepeats;
				if (truncateDiceValues) {
					truncateDiceList(listDiceValues, diceValue);
				}
				break;
			}						
		}
		return score;
	}

	public static void truncateDiceList(List<Integer> diceValues, Integer diceValue) {
		diceValues.removeAll(Collections.singleton(diceValue));		
	}
	

}
