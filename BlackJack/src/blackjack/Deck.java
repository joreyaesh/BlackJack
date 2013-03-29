package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public Class Deck{
	
<<<<<<< HEAD
	public static void main(String[] args){
		Deck deck = new Deck();
		for(int i = 0; i<deck.length(); i++){
			System.out.println(deck[i].getFaceValue() + " of " + deck[i].getSuit());
		}
	}
	
=======
	int playerScore = 0;
	int dealerScore = 0;
>>>>>>> 3/29/13 Allyseia1
	private List cards = new ArrayList(52);
	
	Scanner kb = new Scanner(System.in);
	
	public void Deck(){
		for(int i = 1; i<=4; i++){
		// 4 suits
		  for(int i2 = 1; i2<=13; i2++){
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
	
	if ((dealerScore != 21) && (playerScore != 21))
	{
		System.out.println("Would you like to hit? (Y/N)");
		hit = kb.readLine();
		hit = hit.toUpperCase();
		
	}
	
	
}