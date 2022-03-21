/*******************************************************************
 War Game Card
Lior Mary 
*********************************************************************/

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;


public class WarGameMain extends Application{ 

	public void start(Stage stage) throws Exception{ 
		boolean flag = true;
		DeckOfCards player1Deck = new DeckOfCards(); //the deck of player 1
		DeckOfCards player2Deck = new DeckOfCards(); //the deck of player 2
		DeckOfCards pack = new DeckOfCards(); //the deck of dealer
		pack.shuffle(); //shuffle the dealer deck 
		player1Deck.EmptyDeckOfCards(); // empty player 1 deck
		player2Deck.EmptyDeckOfCards(); // empty player 2 deck
		pack.splitDeck(player1Deck , player2Deck); //s split the deck to the two players
		pack.EmptyDeckOfCards(); // make sure the dealer pack is empty
		
		Alert alert = new Alert(null, "Welcome to war game card \n Press next to start ", ButtonType.NEXT, ButtonType.FINISH);
		alert.showAndWait();

		while (flag) {
			if (alert.getResult() == ButtonType.NEXT) {
				if (player1Deck.isEmpty() && player2Deck.isEmpty()) { //both of the players has no more cards
					flag= false;
					alert.setContentText("Both of the decks is empty, It's a tie!");
					alert.show();
				}
				else if (player1Deck.isEmpty() && !(player2Deck.isEmpty())) { //player 1 has no more cards
					flag= false;
					alert.setContentText("Player 1 deck is empty, Player 2 has won the game!");
					alert.show();
				}
				else if (!(player1Deck.isEmpty()) && player2Deck.isEmpty()) { // player 2 has no more cards
					flag= false;
					alert.setContentText("Player 2 deck is empty, Player 1 has won the game!");
					alert.show();
				}
				else {
					Card p1 = player1Deck.dealCard(); //deal one card of player 1
					Card p2 = player2Deck.dealCard(); //deal one card of player 2
					alert.setContentText("Player 1 card is " + p1.toString() + "\n Player 2 card is " + p2.toString());
					alert.showAndWait();
					int valueP1 = p1.getCardValue(); // get the value of the card of player 1
					int valueP2 = p2.getCardValue(); // get the value of the card of player 2
					if (valueP1 > valueP2) { // player 1 has won this round of the game
						player1Deck.removeFromDeck();
						player2Deck.removeFromDeck();
						player1Deck.addToDeck(p1);
						player1Deck.addToDeck(p2);
						while(!(pack.isEmpty())) { // if there is cards in the dealer pack, player 1 will win them
							Card c = pack.dealCard();
							player1Deck.addToDeck(c);
							pack.removeFromDeck();
						}
						alert.setContentText("Player 1 has won this round");
						alert.showAndWait();
					}
					else if (valueP1 < valueP2) { // player 2 has won this round of the game
						player1Deck.removeFromDeck();
						player2Deck.removeFromDeck();
						player2Deck.addToDeck(p1);
						player2Deck.addToDeck(p2);
						while(!(pack.isEmpty())) { // if there is cards in the dealer pack, player 2 will win them
							Card c = pack.dealCard();
							player2Deck.addToDeck(c);
							pack.removeFromDeck();
						}
						alert.setContentText("Player 2 has won this round");
						alert.showAndWait();
					}
					else {
						alert.setContentText("war!"); // player 1 and player 2 has the same card value
						alert.showAndWait();
						player1Deck.removeFromDeck();
						player2Deck.removeFromDeck();
						if (player1Deck.moreThanThree() && player2Deck.moreThanThree()) { //check if both of the players have 3 cards for the war
							pack.addToDeck(p1); // add the card of player 1 to the dealer deck
							pack.addToDeck(p2);// add the card of player 2 to the dealer deck
							Card oneP1 = player1Deck.dealCard();
							pack.addToDeck(oneP1); // add card 1 of the war of player 1 to the dealer deck
							Card twoP1 = player1Deck.dealCard();
							pack.addToDeck(twoP1); // add card 2 of the war of player 1 to the dealer deck
							Card oneP2 = player1Deck.dealCard();
							pack.addToDeck(oneP2); // add card 1 of the war of player 2 to the dealer deck
							Card twoP2 = player1Deck.dealCard();
							pack.addToDeck(twoP2); // add card 2 of the war of player 2 to the dealer deck
						}
						else if (!(player1Deck.moreThanThree()) && player2Deck.moreThanThree()) { //player 1 don't have 3 cards for the war
							flag= false;
							alert.setContentText("There is not enough cards in player 1 deck, Player 2 has won the game!");
							alert.show();
						}
						else if (player1Deck.moreThanThree() && !(player2Deck.moreThanThree())) { //player 2 don't have 3 cards for the war
							flag= false;
							alert.setContentText("There is not enough cards in player 2 deck, Player 1 has won the game!");
							alert.show();
						}
					}
				}
			}
		}
	}


	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
}


