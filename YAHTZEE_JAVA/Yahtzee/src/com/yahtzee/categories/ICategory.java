package com.yahtzee.categories;

import java.util.List;

public interface ICategory {
	int getCategoryScore(List<Integer> listDiceValues);
}
