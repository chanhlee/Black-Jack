/*
* [Card].java
* Author: [Chanhee Lee]
* Submission Date: [11/29/2016]
*
* Purpose: Class definition for cards involved in the Black Jack game as a part of the BlackJack Project.
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
import javafx.scene.image.Image;

public class Card {
	
	/**
	 * Suits of a card deck
	 */
	public static enum Suit{
		CLUB, DIAMOND, HEART, SPADE
	}
	
	/**
	 * Types of cards
	 */
	public static enum Type {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	private Suit suit;
	private Type type;
	
	/**
	 * Create a card with Type type and Suit suit
	 * @param type type of the card
	 * @param suit suit of the card
	 */
	public Card(Type type, Suit suit) {
		this.suit =  suit;
		this.type = type; //does this work for enumerations?  
	}
	
	/**
	 * Checks if this card equals card c
	 * @param c Card to compare
	 * @return boolean true if the suit and type of the cards match
	 */
	public boolean equals(Card c) {
		if (this.suit == c.suit && this.type == c.type)
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns a String representation of the Card (ex. ACE OF SPADES)
	 */
	@Override
	public String toString() {
		String string = this.type + " OF " + this.suit + "S";
		return string; 
	}
	/* TEST FOR toString()
	public static void  main (String[] args){
		Card card1 = new Card(Type.ACE, Suit.HEART);
		System.out.println(card1.toString());
	}
	*/
	
	/**
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return the type of the card
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Don't worry about this method. This is for the Graphical User Interface
	 * @return the image of the card
	 */
	public Image getImage() {
		return new Image("file:classic-cards/" + this.getType() + "" + this.getSuit() + ".png");
	}
}
