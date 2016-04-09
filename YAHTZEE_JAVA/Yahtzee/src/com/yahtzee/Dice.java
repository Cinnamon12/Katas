package com.yahtzee;

public enum Dice {
	one(1),
	two(2),
	three(3),
	four(4),
	five(5),
	six(6);
	
	public int diceValue;
	private Dice(int diceValue){
		this.diceValue = diceValue;
	}
	
	public int getDiceValue(){
		return diceValue;
	}
}
