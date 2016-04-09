package com.yahtzee;

import java.util.List;

import com.yahtzee.categories.ChanceCategory;
import com.yahtzee.categories.FullHouseCategory;
import com.yahtzee.categories.ICategory;
import com.yahtzee.categories.MatchXSameKindCategory;
import com.yahtzee.categories.NsCategory;
import com.yahtzee.categories.PairCategory;
import com.yahtzee.categories.SmallOrLargeStraightCategory;
import com.yahtzee.categories.TwoPairCategory;

public enum CategoryEnum {
	ones(new NsCategory(1)),
    twos(new NsCategory(2)),
    threes(new NsCategory(3)),
    fours(new NsCategory(4)),
    fives(new NsCategory(5)),
    sixes(new NsCategory(6)),
    pair(new PairCategory()),
    twopair(new TwoPairCategory()),
    threeOfAKind(new MatchXSameKindCategory(3)),
    fourOfAKind(new MatchXSameKindCategory(4)),
    yahtzee(new MatchXSameKindCategory(5)),
	smallStraight(new SmallOrLargeStraightCategory(1)),
	largeStraight(new SmallOrLargeStraightCategory(2)),	
    fullHouse(new FullHouseCategory()),
    chance (new ChanceCategory());

    private ICategory categoryChosen;

    private CategoryEnum(ICategory evaluationStrategy) {
        this.categoryChosen = evaluationStrategy;
    }

    Integer evaluate(List<Integer> listDiceValues) {
        return this.categoryChosen.getCategoryScore(listDiceValues);
    }
}
