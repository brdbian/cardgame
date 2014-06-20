package com.channelsoft.cardgame;

public class App 
{
    public static void main( String[] args ) {
    	CardDeck.initCards();
    	for(int i=0;i<108;i++){
    		System.out.println("牌堆大小"+CardDeck.getCards().size());
    		System.out.println(CardDeck.getRandomCard());
    	}
    }
}
