package blackjack;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Player{
	
	
	private String name;
	double wallet;
	private int bet, total = 0;
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	
	public Player(){
		setName("No Name Provided");
		setWallet(0);
	}
	
	public Player(String name, double wallet){
		setName(name);
		setWallet(wallet);
	}
	
	// Used for when the player sets the bet
	public void placeBet(){ 
		int bet;
		
		do{
			String message = "You currently have $" + getWallet() + " to bet.\n" + "What would you like to bet?";
			String input = "A whole number; at least $10";
			String response = JOptionPane.showInputDialog(message, input);
			// error handling
			if(response == null || response.equals("A whole number; at least $10")){
				bet = 0;
			}
			else{
				bet = Integer.parseInt(response);
			}
		} while(bet < 10);
		setBet(bet);
	}
	
	// Used to change get paid/pay
	public void pay(double amount){
		double current = this.wallet;
		current += amount;
		setWallet(current);
	}
	
	// Used so the dealer can match the player's bet
	public void matchBet(int bet){
		setBet(bet);
	}
	
	private void setBet(int bet){
		if(bet <= wallet){ // Check for insufficient funds
			double current = this.wallet;
			current -= bet;
			setWallet(current);
			this.bet = bet;
		}
		else{
			String message = name + " has insufficient funds to bet $" + Integer.toString(bet) + ".";
			JOptionPane.showMessageDialog(null, message);
			this.bet = 0;
		}
	}
	
	public int getBet(){
		int result = bet;
		return result;
	}
	
	private void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		String result = name;
		return result;
	}
	
	private void setWallet(double wallet){
		this.wallet = wallet;
	}
	
	public double getWallet(){
		double result = wallet;
		return result;
	}
	
	private void setTotal(int total){
		this.total = total;
	}
	
	public int getTotal(){
		int result = total;
		return result;
	}
	
	public ArrayList<Card> getHand(){
		ArrayList<Card> hand = this.hand;
		return hand;
	}
	
	public void takeHand(){
		clearHand();
		requestCards(2);
	}
	
	public void requestCards(int num){
		for(int i=0; i<num; i++){
			hand.add(Driver.deck.takeCard());
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

	public void checkAce() {
		for(int i = 0; i<hand.size(); i++){
			if(hand.get(i).getFaceValue() == 11){
				hand.get(i).lowerAce();
			}
		}
		updateTotal();
	}
		
}
