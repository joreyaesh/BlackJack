package blackjack;

public Class Card{
  
  private int faceValue = 0;
  private String faceName, suit = "";
  
  public void Card(int faceValue, int suitValue){
    this.faceValue = faceValue;
    switch(faceValue){
      case 1:  faceName = "Ace";
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
  
  
}