/*******************************************************************
Card object and his methods for war game card
Lior Mary 
*********************************************************************/

public class Card {

	private final String face; // face of card ("Ace", "Deuce",..) 
	private final String suit; // suit of card ("Hearts", "Diamonds",..) 

	// two argument constructor initializes card's face and suit 
	public Card(String cardFace, String cardSuit ) {
		this.face = cardFace; // initialize face of card 
		this.suit = cardSuit; // initialize suit of card 
	}
	
	// create to string method
	public String toString() {
		return face + " of " + suit;
	}

	// method that gets string and returns the card value 
	public int getCardValue() {
        if (this.face.equals("Ace")) {
            return 1;
        } else if (this.face.equals("Deuce")) {
            return 2;
        } else if (this.face.equals("Three")) {
            return 3;
        } else if (this.face.equals("Four")) {
            return 4;
        } else if (this.face.equals("Five")) {
            return 5;
        } else if (this.face.equals("Six")) {
            return 6;
        } else if (this.face.equals("Seven")) {
            return 7;
        } else if (this.face.equals("Eight")) {
            return 8;
        } else if (this.face.equals("Nine")) {
            return 9;
        } else if (this.face.equals("Ten")) {
            return 10;
        } else if (this.face.equals("Jack")) {
            return 11;
        } else if (this.face.equals("Queen")) {
            return 12;
        } else if (this.face.equals("King")) {
            return 13;
        }
        return 0;
    }

}
