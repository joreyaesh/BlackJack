package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public Class Deck{
	
	private List cards = new ArrayList(52);
	
	public void Deck(){
		for(int i = 1; i<=4; i++){
		// 4 suits
		  for int i2 = 1; i2<=13; i2++{
		    Card card = new Card(i2, i); // i2 is the face value, i is suit value
		    cards.add(card);
		  }
		}
		shuffle(cards);
	}
	
	public void shuffle(ArrayList cards){
		// shuffle cards with the shuffle function built into Collections
	  Collections.shuffle(cards);
	}
	
	
	
}