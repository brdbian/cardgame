package com.channelsoft.cardgame;

public class Dice {
	public static int roll(int seed){
		int r = (int) (Math.random() * seed); 
		return r+1;
	}
}
