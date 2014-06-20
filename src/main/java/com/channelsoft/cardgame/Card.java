package com.channelsoft.cardgame;

public class Card {
	private String color;
	private String number;
	private int score;
	
	public Card(String color,String number,int score){
		this.color = color;
		this.number = number;
		this.score = score;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString(){
		return color+number+" 积分"+score;
	}

	
}
