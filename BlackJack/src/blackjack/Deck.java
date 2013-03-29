package blackjack;

import java.util.ArrayList;
import java.util.Collections;
<<<<<<< HEAD
import java.util.*;

public class Deck{
	
<<<<<<< HEAD
	public static void main(String[] args){
		Deck deck = new Deck();
		for(int i = 0; i<deck.getLength(); i++){
			System.out.println(deck.cards.get(i).getFaceName() + " of " + deck.cards.get(i).getSuit());
		}
	}
	
<<<<<<< HEAD
=======
	int playerScore = 0;
	int dealerScore = 0;
>>>>>>> 3/29/13 Allyseia1
	private List cards = new ArrayList(52);
=======
import java.util.List;
import java.util.Scanner;

public class Deck{
	
	private int playerScore = 0;
	private int dealerScore = 0;
	
	private List cards = new ArrayList<Card>(52);
	String hit;
>>>>>>> 3/29/13 Allyseia3
	
	Scanner kb = new Scanner(System.in);
	
	
	public void Deck(){
=======
	private int getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	private int length = 0;
	private List<Card> cards = new ArrayList<Card>(52);
	
	public Deck(){
>>>>>>> Fixed Card and Deck Classes
		for(int i = 1; i<=4; i++){
		// 4 suits
		  for (int i2 = 1; i2<=13; i2++){
		    Card card = new Card(i2, i); // i2 is the face value, i is suit value
		    cards.add(card);
		    length++;
		  }
		}
		shuffle(cards);
	}
	
<<<<<<< HEAD
	public void shuffle(List<Card> cards){
=======
	public void shuffle(ArrayList cards)
	{
>>>>>>> 3/29/13 Allyseia3
		// shuffle cards with the shuffle function built into Collections
	  Collections.shuffle(cards);

	}

	
	//if ((dealerScore != 21) && (playerScore != 21))
	//{
		//System.out.println("Would you like to hit? (Y/N)");
		//hit = kb.readLine();
		//hit = hit.toUpperCase();
		
	}
	
	
