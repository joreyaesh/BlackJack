package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Deck{

	private List<Card> cards = new ArrayList<Card>(52);

	public Deck(){
		for(int i = 1; i<=4; i++){
			// 4 suits
			for(int i2 = 1; i2<=13; i2++){
				Card card = new Card(i2, i); // i2 is the face value, i is suit value
				cards.add(card);
			}
		}
		shuffle(cards);
	}
	
	public Deck(int decks){
		for(int deck = 1; deck<=decks; deck++){ // number of decks to shuffle together
			for(int i = 1; i<=4; i++){
				// 4 suits
				for(int i2 = 1; i2<=13; i2++){
					Card card = new Card(i2, i); // i2 is the face value, i is suit value
					cards.add(card);
				}
			}
			shuffle(cards);
		}
	}
	
	public List<Card> getCards(){
		List<Card> cards = this.cards;
		return cards;
	}

	public void shuffle(List<Card> cards){
		// shuffle cards with the shuffle function built into Collections
		Collections.shuffle(cards);
	}

	public Card takeCard() {
		Card card = cards.remove(0);
		return card;
	}


}