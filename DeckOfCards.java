/*******************************************************************
Deck Of Cards object and his methods for war game card
Lior Mary 
 *********************************************************************/

import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {

	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards 
	private ArrayList<Card> deck = new ArrayList<Card>(NUMBER_OF_CARDS); // array of Card object 
	private static final SecureRandom randomNumbers = new SecureRandom(); // random number generator

	// constructor fills deck of Cards 
	public DeckOfCards() {
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};


		// populate deck with Card objects 
		for (int count = 0; count < NUMBER_OF_CARDS; count++) {
			deck.add(new Card(faces[count % 13], suits[count / 13]));
		}
	}

	//method that empty full deck of cards
	public void EmptyDeckOfCards() {
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			if (!(deck.isEmpty())) {
				deck.remove(0);
			}
		}
	}

	// shuffle deck of Cards with one-pass algorithm 
	public void shuffle() {

		// for each Card, pick another random Card (0-51) 
		for (int first = 0; first < deck.size(); first++) {
			// select a random number between 0 to 51 
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			// swap current Card with randomly selected Card 
			Card temp = deck.get(first);
			deck.set(first, deck.get(second));
			deck.set(second, temp);
		}
	}

	// deal one Card 
	public Card dealCard() {
		return deck.get(0); // return current Card in array 
	}

	//add one card to the end of the deck
	public void addToDeck(Card c) {
		deck.add(c);
	}

	//remove the first card from the deck
	public void removeFromDeck() {
		deck.remove(0);
	}

	//spit one deck to two decks
	public void splitDeck(DeckOfCards d1, DeckOfCards d2) {
		for (int i = 0; i < 25; i++) {
			d1.addToDeck(deck.get(0));
			deck.remove(0);
		}
		for (int i = 26; i < 51; i++) {
			d2.addToDeck(deck.get(0));
			deck.remove(0);
		}
	}

	//method that checks if the deck is empty
	public boolean isEmpty() {
		return deck.isEmpty();
	}

	//method that checks if there is more than 3 cards in the deck
	public boolean moreThanThree() {
		int three = 0;
		for (int i = 0; i < deck.size(); i++) {
			three++;
		}
		if (three >= 3) return true;
		else return false;
	}
}



