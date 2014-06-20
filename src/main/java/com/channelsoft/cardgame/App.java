package com.channelsoft.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
	private static int index = 0;
    public static void main( String[] args ) {
    	Scanner sc = new Scanner(System.in);
    	initCardTable();
    	initPerson(sc);
    	for(Person p : CardTable.getPersons()){
    		printPerson(p);
    	}
    	for(int i=0;i<3;i++){
    		getCard();
    		replaceCard(sc);
    		getScore();
    		index++;
    	}
    }

	private static void getScore() {
		Person temp = CardTable.getPersons().get(index%3);
		Map<String,List<Card>> map = new HashMap<String, List<Card>>();
		for (int i = 0; i < CardTable.getCards().size(); i++) {
			String number = CardTable.getCards().get(i).getNumber();
			if(map.containsKey(number)){
				map.get(number).add(CardTable.getCards().get(i));
			}else{
				List<Card> list = new ArrayList<Card>();
				list.add(CardTable.getCards().get(i));
				map.put(number,list);
			}
		}
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			if(map.get(key).size()>=3){
				System.out.println(""+key+"的个数为"+map.get(key).size());
				CardTable.getCards().removeAll(map.get(key));
				temp.setScore(temp.getScore()+map.get(key).get(0).getScore()*map.get(key).size());
			}
		}
	}

	private static void replaceCard(Scanner sc) {
		System.out.println("选择自己的一张牌：");
		int num = sc.nextInt();
		System.out.println("选择牌桌上的一张牌：");
		int num1 = sc.nextInt();
		Person temp = CardTable.getPersons().get(index%3);
		Card card = temp.getCards().remove(num-1);
		Card card1 = CardTable.getCards().set(num1-1, card);
		temp.getCards().add(card1);
		printPerson(temp);
	}

	private static void getCard() {
		System.out.println("从前一个人手中取牌：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		Person temp = CardTable.getPersons().get(index%3);
		int prevIndex = index+2;
		Person prev = CardTable.getPersons().get(prevIndex%3);
		temp.getCardFromPerson(prev,num-1);
		
		for(Person p : CardTable.getPersons()){
    		printPerson(p);
    	}
	}

	private static void printPerson(Person p) {
		System.out.println(p.getName()+p.getRollNumber());
		System.out.println("手上的牌：");
		for(Card c:p.getCards()){
			System.out.println("\t"+c);
		}
	}

	private static void initPerson(Scanner sc) {
		for(int i = 0;i<3;i++){
			System.out.println("第"+(i+1)+"个人加入");
			System.out.println("请输入姓名:");
//			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			Person p = new Person(name);
	    	p.setRollNumber(Dice.roll(6));
	    	p.initCards();
	    	CardTable.joinGame(p);
	    	printPerson(p);
		}
		Collections.sort(CardTable.getPersons());
	}

	private static void initCardTable() {
		CardTable.initTable();
    	for(Card card:CardTable.getCards()){
    		System.out.println(card);
    	}
	}
    
}
