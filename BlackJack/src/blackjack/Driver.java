package blackjack;

import javax.swing.JOptionPane;

public class Driver {

	
	public static void main(String[] args) {
		
		// Prompt for player's name
		String name = JOptionPane.showInputDialog("What is the player's name?");
		
		// Create player and dealer objects
		Player player = new Player(name, 1000); // Player starts with $1,000 
		Player dealer = new Player("Dealer", 10000); // Dealer starts with $10,000
		
		// Get 4 decks, shuffled together
		Deck cards = new Deck(4);
		
		
		// Ask if the user would like to play another hand:  0 = yes, 1 = no, -1 = cancel
		int response = JOptionPane.showOptionDialog(null, "Would you like to play a hand of BlackJack?", "New Hand?", 0, 0, null, null, null);
		
		if(response == 0){ // if yes
			play();
		}
		else { // else if no, or "X"
			String message = "Thank you for playing! \n" +
					"You finished with $" + player.getWallet() + ".";
			JOptionPane.showMessageDialog(null, message);
			System.exit(0);
		}
		
	}
	
	
	public static void play(){
		
	}

}
