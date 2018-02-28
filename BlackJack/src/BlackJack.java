/*
* [BlackJack].java
* Author: [Chanhee Lee]
* Submission Date: [11/29/2016]
*
* Purpose: Class definition for BlackJack involved in the Black Jack game as a part of the BlackJack Project.
* Defines relevant instance variables and methods related to the this class (mostly those related to the game and static methods
* that will help methods in other classes). 
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science.
*/
/**
 * Class representing a single player blackjack game
 */
public class BlackJack {
	
	private Deck deck;
	private Dealer dealer;
	private Player player;


	/**
	 * Constructs and prepares for a new game of BlackJack.
	 * Creates player, dealer and deck objects then shuffles
	 * the deck and gives both the dealer and player two cards.
	 */
	public BlackJack() {
		deck = new Deck();
		dealer = new Dealer(); 
		player = new Player();
		Hand dealerHand = dealer.getHand();
		Hand playerHand = player.getHand();
		deck.shuffle(); 
		playerHand.addCard(deck.draw()); 
		playerHand.addCard(deck.draw()); 
		dealerHand.addCard(deck.draw());
		dealerHand.addCard(deck.draw());
	}
	/**
	 * Restarts in a few steps
	 * 1. The Player and dealer return their cards to the deck.
	 * 2. The deck is shuffled.
	 * 3. Both the player and the dealer receive two cards drawn form the top of the deck.
	 */
	public void restart() {
		//1. The Player and dealer return their cards to the deck.
		Hand dealerHand = dealer.getHand();
		Hand playerHand = player.getHand();
		Card[] emptiedPlayer = playerHand.emptyHand();
		Card[] emptiedDealer = dealerHand.emptyHand();
		for (int i=0; i < emptiedPlayer.length; i++){
			deck.addToBottom(emptiedPlayer[i]);
		}
		for (int i=0; i < emptiedDealer.length; i++){
			deck.addToBottom(emptiedDealer[i]);
		}
		//2. deck is shuffled
		deck.shuffle(); 
		//3. Both the player and the dealer receive two cards drawn form the top of the deck.
		playerHand.addCard(deck.draw()); 
		playerHand.addCard(deck.draw()); 
		dealerHand.addCard(deck.draw());
		dealerHand.addCard(deck.draw());
	}
	/**
	 * Returns the value of a card in a standard game of Blackjack based on the type of the card
	 * ex. An Ace would return 1, a 2 would return 2... 
	 * @param c card whose value is extracted
	 * @return value of the card
	 */
	public static int getValueOfCard(Card c) {
		if (c.getType().ordinal()+1 >= 10){	//TEN, JACK, QUEEN, and KING will return 10
			return 10; 
		}
		else {
			return c.getType().ordinal()+1;	//uses the ordinal position of enumeration as an int 
		}									//position starts at 0 so "+1" returns the int of its value
	}										//E.g. ONE has a ordinal value of 0, so to get its int value, you would add 1 to 0 which wouldl return 1
	/**
	 * Returns the maximum value of the hand that does not result in a bust
	 * @param h Hand whose value is returned
	 * @return value of h
	 */
	public static int getValueOfHand(Hand h) {
		int valueOfHand = 0; 
		Card[] clone = h.getCards().clone(); 
		for (int i=0; i < h.getCards().length; i++){	//Adds cards that are not aces first 
			if (getValueOfCard(clone[i]) != 1){
				valueOfHand += getValueOfCard(clone[i]);
			}
		}
		for (int i=0; i < h.getCards().length; i++){
			if (getValueOfCard(clone[i]) == 1){
				if (valueOfHand + 11 > 21)
					valueOfHand += 1; 	//adds 1 for the first card being Ace
				else if (valueOfHand + 11 <= 21)
					valueOfHand +=11;	//adds 11 for the first card being Ace
			}
		}
		return valueOfHand;
	}

	/**
	 * @return Deck used to play
	 */
	public Deck getDeck() {
		return deck;
	}
	
	/**
	 * @return Dealer of the game
	 */
	public Dealer getDealer() {
		return dealer;
	}
	
	/**
	 * @return Player playing the blackjack game
	 */
	public Player getPlayer() {
		return player;
	}

}
