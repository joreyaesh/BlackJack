package blackjack;

import javax.swing.JOptionPane;

public class Driver {

	static Deck deck;
	private static Player player, dealer;

	public static void main(String[] args) {

		// Prompt for player's name
		String name = JOptionPane.showInputDialog("What is the player's name?");

		// Create player and dealer objects
		player = new Player(name, 1000.00); // Player starts with $1,000 
		dealer = new Player("The Dealer", 100000.00); // Dealer starts with $100,000

		// Get 4 decks, shuffled together
		deck = new Deck(4);

		// Ask if the user would like to play another hand:  0 = yes, 1 = no, -1 = cancel
		int response = 0;
		while(response == 0 && player.getWallet() >= 10){
			play();
			response = JOptionPane.showOptionDialog(null, "Would you like to play another hand of BlackJack?", "New Hand?", 0, 0, null, null, null);
		}
		String message = "Thank you for playing!\n" +
				player.getName() + " finished with $" + player.getWallet() + "!";
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);

	}


	// Plays one hand
	public static void play(){

		// Make the bets
		player.placeBet(); // prompt for and place player's bet: if funds are insufficient, bet is set to 0
		dealer.matchBet(player.getBet()); // match the player's bet

		// Distribute cards
		player.takeHand();
		dealer.takeHand();
		

		// Prompt for hit/stay while there is no Blackjack or bust
		while(player.getTotal() < 21 && dealer.getTotal() < 21){
			String message = "Your hand contains the following: "; // display current hand
			for(int i = 0; i<player.getHand().size(); i++){
				message += player.getHand().get(i).getFaceName() + " ";
			}
			message += "\n" + "For a total of: " + player.getTotal() + // display current total
					"\n" + "The Dealer has a " + dealer.getHand().get(0).getFaceName() + " showing."; // display what dealer's card is showing
			Object[] options = {"Hit", "Stay"};
			int response = JOptionPane.showOptionDialog(null,
					message, "Hit or Stay?", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, null);

			if(response == 0){ // if Hit
				player.requestCards(1);
			}
			else{ // if Stay or "X"
				break;
			}

			// Check for a bust w/ an ace
			if(player.getTotal() > 21){
				player.checkAce(); // If there is an ace, subtract 10
			}
		}
		
		// dealer hits if they have below 16 and have less than the player
		while(dealer.getTotal() < 16 && dealer.getTotal() < player.getTotal()){
			dealer.requestCards(1);
			
			if(dealer.getTotal() > 21){
				dealer.checkAce(); // check ace if bust
			}
		}
		
		
		// If player has a blackjack and dealer doesn't
		if(player.getTotal() == 21 && dealer.getTotal() != 21){
			String message = "You got a BlackJack!\n" +
					"You won $" + (player.getBet()*1.5 + player.getBet()) + "!";
			JOptionPane.showMessageDialog(null, message);
			double payout = player.getBet()*1.5 + player.getBet();
			player.pay(payout); // pay player: 3:2
			dealer.pay(-(payout)); // take dealer's money
		}

		// If dealer has a blackjack and player doesn't 
		else if(player.getTotal() != 21 && dealer.getTotal() == 21){
			String message = "The dealer got a BlackJack..\n" +
					"You lost $" + Integer.toString(player.getBet()) + ".";
			JOptionPane.showMessageDialog(null, message);
			double payout = dealer.getBet() * 2;
			dealer.pay(payout); // give dealer money
		}

		// If dealer and player tied
		else if(player.getTotal() == dealer.getTotal()){
			String message = "The dealer and player tied.\n" +
					"You lost $0.";
			JOptionPane.showMessageDialog(null, message);
			double payout = dealer.getBet();
			dealer.pay(payout); // give dealer their bet back
			player.pay(payout); // give player their bet back
		}
		
		// If player busted
		else if(player.getTotal() > 21){
			String message = "You busted!\n" +
					"You lost $" + Integer.toString(player.getBet()) + ".";
			JOptionPane.showMessageDialog(null, message);
			double payout = dealer.getBet() * 2;
			dealer.pay(payout); // give dealer money
		}
		
		// If dealer busted
		else if(dealer.getTotal() > 21){
			String message = "The dealer busted!\n" +
					"You won $" + Integer.toString(dealer.getBet()) + "!";
			JOptionPane.showMessageDialog(null, message);
			double payout = player.getBet() * 2;
			player.pay(payout); // give player money
		}
		
		// If no blackjacks or busts
		else{
			if(dealer.getTotal() > player.getTotal()){ // if dealer has higher
				String message = "The dealer won.\n" + "The Dealer's total: " + Integer.toString(dealer.getTotal())
						+ "\n" + "Your total: " + Integer.toString(player.getTotal()) + "\n" +
						"You lost $" + Integer.toString(dealer.getBet()) + ".";
				JOptionPane.showMessageDialog(null, message);
				double payout = dealer.getBet() * 2;
				dealer.pay(payout); // give dealer money
			}
			else{ // if player has higher
				String message = "You won!\n" + "The Dealer's total: " + Integer.toString(dealer.getTotal())
						+ "\n" + "Your total: " + Integer.toString(player.getTotal()) + "\n" +
						"You won $" + Integer.toString(dealer.getBet()) + ".";
				JOptionPane.showMessageDialog(null, message);
				double payout = player.getBet() * 2;
				player.pay(payout); // give player money
			}
		}
		
	}

	// if there are no more cards, this is called
	public static void requestDeck() {
		deck = new Deck(4); // adds 4 more decks
		
	}

}

