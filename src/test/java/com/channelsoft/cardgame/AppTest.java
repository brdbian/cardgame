package com.channelsoft.cardgame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		CardTable.initTable();
    	for(Card card:CardTable.getCards()){
    		System.out.println(card);
    	}
    	
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
//				System.out.println(""+key+"的个数为"+map.get(key).size());
//				for(int j =0;j<map.get(key).size();j++){
//					System.out.println(map.get(key).get(j));
//				}
				CardTable.getCards().removeAll(map.get(key));
			}
		}
		System.out.println("----");
		
		for(Card card:CardTable.getCards()){
    		System.out.println(card);
    	}
	}

}
