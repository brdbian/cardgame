package com.channelsoft.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Person implements Comparable<Person>{
	public boolean inAction = false;
	private String name;
	private int rollNumber;
	private List<Card> cards;
	private int score;
	
	public Person(String name){
		this.name = name;
	}
	
	public void initCards(){
		cards = new ArrayList<Card>();
		cards.add(CardDeck.getRandomCard());
		cards.add(CardDeck.getRandomCard());
		cards.add(CardDeck.getRandomCard());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void getCardFromPerson(Person prev,int position){
		cards.add(prev.getCards().remove(position));
	}

	public int compareTo(Person o) {
		if(rollNumber>o.getRollNumber()){
			return -1;
		}else if(rollNumber<o.getRollNumber()){
			return 1;
		}
		return 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
