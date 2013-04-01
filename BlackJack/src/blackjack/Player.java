package blackjack;

import java.util.ArrayList;


public class Player{
	
	
	private String name;
	private int wallet, bet, total = 0;
	private ArrayList<Card> hand;
	
	
	public Player(){
		
	}
	
	public Player(String name, int wallet){
		setName(name);
		setWallet(wallet);
		hand = new ArrayList<Card>();
	}
	
	private void setBet(int bet){
		this.bet = bet;
	}
	
	public int getBet(){
		return bet;
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	private void setWallet(int wallet){
		this.wallet = wallet;
	}
	
	public int getWallet(){
		return wallet;
	}
	
	private void setTotal(int total){
		this.total = total;
	}
	
	public int getTotal(){
		return total;
	}
	
	public void playHand(int bet){
		clearHand();
		setBet(bet);
		requestCards(2);
	}
	
	public void requestCards(int num){
		for(int i=0; i<num; i++){
			hand.add(Deck.giveCard());
		}
		updateTotal();
	}
	
	private void clearHand(){
		hand.removeAll(hand);
		setTotal(0);
	}
	
	private void updateTotal(){
		setTotal(0);
		for(int i = 0; i<hand.size(); i++){
			total += hand.get(i).getFaceValue();
		}
		setTotal(total);
	}
		
}
