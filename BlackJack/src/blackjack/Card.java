package blackjack;

public class Card{

	private int faceValue = 0;
	private String faceName, suit = "";

	public Card(int faceValue, int suitValueInt){
		if(faceValue <= 10) this.faceValue = faceValue;
		else{
			this.faceValue = 10;
		}
		switch(faceValue){
		case 1:  faceName = "Ace";
				 this.faceValue = 11;
		break;
		case 11: faceName = "Jack";
		break;
		case 12: faceName = "Queen";
		break;
		case 13: faceName = "King";
		break;
		default: faceName = Integer.toString(faceValue);
		}
		switch(suitValueInt){
		case 1:  suit = "Hearts";
		break;
		case 2:  suit = "Diamonds";
		break;
		case 3:  suit = "Spades";
		break;
		case 4:  suit = "Clubs";
		break;
		default: suit = "Invalid Suit";
		break; 
		}

	}


	public int getFaceValue(){
		return faceValue;
	}

	public String getFaceName(){
		return faceName;
	}

	public String getSuit(){
		return suit;
	}

	public String toString(){
		String result = faceName + " of " + suit;
		return result;
	}


	public void lowerAce() {
		this.faceValue = 1;
	}


}