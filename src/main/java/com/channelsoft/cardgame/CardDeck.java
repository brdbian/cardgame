package com.channelsoft.cardgame;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	private static String[] card1 = { "黑桃", "红桃", "梅花", "方块" };
	private static String[] card2 = { "A", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "J", "Q", "K" };

	private static List<Card> cards;

	public static List<Card> getCards() {
		return cards;
	}

	public static void initCards() {
		cards = new ArrayList<Card>();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 12; j++) {
				cards.add(new Card(card1[i], card2[j],j+1)); // 把扑克牌存入card中
			}
		}
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 12; j++) {
				cards.add(new Card(card1[i], card2[j],j+1)); // 把扑克牌存入card中
			}
		}
		cards.add(new Card("小", "王",0));
		cards.add(new Card("小", "王",0));
		cards.add(new Card("大", "王",0));
		cards.add(new Card("大", "王",0));
	}
	
	public static Card getRandomCard(){
		if(cards==null||cards.size()==0){
			initCards();
		}
		int r = (int) (Math.random() * cards.size()); 
	    Card card = cards.get(r);
	    cards.remove(r);     
	    return card;
	}
}
