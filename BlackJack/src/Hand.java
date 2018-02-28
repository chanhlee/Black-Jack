/*
* [Hand].java
* Author: [Chanhee Lee]
* Submission Date: [11/29/2016]
*
* Purpose: Class definition for the 'hand' involved in the Black Jack game as a part of the BlackJack Project.
* Defines relevant instance variables and methods related to the this class. 
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
 * 
 * @author ghyzel
 *
 */
public class Hand {
	
	/**
	 * The cards in the hand
	 */
	private Card [] cards;
	
	/**
	 * Creates an empty hand
	 */
	public Hand() {
		//Initializing an empty array. 
		//Calling cards.length on this array would return 0
		cards = new Card[0];		//empty hand  
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c card to be added
	 */
	public void addCard(Card c) {
		Card[] newCards = new Card[cards.length + 1];
		for (int i=0; i<cards.length; i++){			//copies current hand into a copy array 
			newCards[i] = cards[i];
		}
		newCards[cards.length] = c; 	//adds new card to the current hand 
		cards = newCards;				//updates the cards instance variable 
	}
	
	/**
	 * @return number of cards in the hand
	 */
	public int size() {
		return cards.length;
	}
	
	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {
		Card[] copyCards = new Card[cards.length];
		for (int i=0; i<cards.length; i++){			//copies current hand into a copy array 
			copyCards[i] = cards[i];
		}
		return copyCards; 
		// Ensure you return reference to the copy of the cards array
		// and not a reference actual cards array!
	}
	
	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {	//Empties the hand (sets the size of the cards array back to 0 – like we did in the constructor) and returns an array of the discarded cards from that hand
		Card[] discardedCards = new Card[cards.length];
		for (int i=0; i<cards.length; i++){			//copies current hand into a copy array 
			discardedCards[i] = cards[i];
		}
		cards = new Card[0];
		return discardedCards;		//array of discarded cards from that hand 
	}
	
	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand"
	 * "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */
	@Override
	public String toString() {
		// HINT: Use the toString() method of the card class
		String string = ""; 
		if (cards.length > 0){
			for (int i=0; i<cards.length; i++){
				string += i + ". " + cards[i].toString();
			}
			return string;
		}
		else {
			string = "Empty hand";
			return string; 
		}
	}
}
