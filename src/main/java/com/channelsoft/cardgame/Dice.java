package com.channelsoft.cardgame;

public class Dice {
	public static int roll(){
		int r = (int) (Math.random() * 7); 
		return r;
	}
}
