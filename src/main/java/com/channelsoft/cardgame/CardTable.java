package com.channelsoft.cardgame;

import java.util.ArrayList;
import java.util.List;

public class CardTable {
	private static List<Card> cards = new ArrayList<Card>();

	private static List<Person> persons = new ArrayList<Person>();
	public static void initTable(){
		for (int i = 0; i < 9; i++) {
			cards.add(CardDeck.getRandomCard());
		}
	}
	
	public static List<Card> getCards() {
		return cards;
	}
	
	public static void joinGame(Person p){
		persons.add(p);
	}

	public static List<Person> getPersons() {
		return persons;
	}
	
}
