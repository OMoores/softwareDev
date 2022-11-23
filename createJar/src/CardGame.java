
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import game.*;

public class CardGame implements Runnable {
    game.Player[] players;
    CardDeck[] cardDecks;

    /**
     * Constructor for new cardgame, creates the object and runs the game
     * 
     */
    public CardGame(game.Player[] players, CardDeck[] cardDecks) {
        this.players = players;
        this.cardDecks = cardDecks;

    }

    /**
     * Writes all of the players current hands to the file
     */
    public void writeAllStartingHands() {
        // Writes starting hand of players to file
        int[][] startingHand = getPlayersHand();
        for (int i = 0; i < players.length; i++) {
            players[i].getFileHandler().startingHand(startingHand[i]);
        }

    }

    /**
     * Commences playing of the game
     */
    public void playGame() {
        writeAllStartingHands();

        // Will hold the int of the winner player, if no one has won the value is set to
        // -1
        int winner = Player.anyoneWon(players);
        // Whilst no one has won plays the game
        while (winner < 0) {

            for (int i = 0; i < players.length; i++) {
                // Runs player threads to simulate them playing the game
                players[i].run();
            }
            // Checks if anyone has won
            winner = Player.anyoneWon(players);

            // writeAllStartingHands();
        }

        for (int i = 0; i < players.length; i++) {
            players[i].getFileHandler().playerWins(winner);
        }

    }

    /**
     * Returns a list of all of the players hands
     * 
     * @return
     */
    public int[][] getPlayersHand() {
        // A list of lists containing each of the players hands
        int[][] hands = new int[players.length][4];

        for (int i = 0; i < players.length; i++) {
            for (int z = 0; z < 4; z++) {
                // Gets the player carddeck, then gets the cards from the deck then gets the
                // value of the card
                hands[i][z] = players[i].getCards().getCards()[z].getCardValue();
            }
        }

        return hands;
    }

    /**
     * Thread
     */
    public void run() {
        System.out.println("Thread");
    }

    /**
     * Creates an instance of the CardGame object which runs the game
     * 
     * @return
     */
    public static CardGame createCardGame() {

        // Gets the number of players in the game
        int userNum = InputHandler.getPlayerNum();

        // Gets the path of a valid pack of cards
        String packPath = InputHandler.getPackPath(userNum);

        // Creating lists to hold players and card decks
        Player[] players = new Player[userNum];
        CardDeck[] cardDecks = new CardDeck[userNum];

        // Creating players and decks
        for (int i = 0; i < userNum; i++) {
            // Creating players and decks
            players[i] = new Player(i);
            cardDecks[i] = new CardDeck();
            // Setting the decks designation (for when printing out what card is given/taken
            // from what deck)
            cardDecks[i].setNum(i);
        }

        // Setting discard and take piles
        players[0].setTakePile(cardDecks[userNum - 1]);
        players[0].setDiscardPile(cardDecks[0]);
        players[0].createFileHandler();
        for (int i = 1; i < userNum; i++) {
            players[i].setTakePile(cardDecks[i - 1]);
            players[i].setDiscardPile(cardDecks[i]);
            players[i].createFileHandler();
        }

        Card[] cardList = FileHandler.getListFromPack(packPath, userNum);
        // Filling in players cards
        for (int playerIndex = 0; playerIndex < userNum; playerIndex++) {
            for (int cardIndex = 0; cardIndex < 4; cardIndex++) {
                players[playerIndex].addCard(cardList[playerIndex * 4 + cardIndex]);
            }

        }

        // Filling in deck cards
        for (int i = 0; i < userNum; i++) {
            for (int deckIndex = 0; deckIndex < userNum; deckIndex++) {
                // Fills in card decks, starting at the point in cardList that would have been
                // emptied assigning cards to players
                cardDecks[deckIndex].addCard(cardList[i * userNum + deckIndex + 4 * userNum - 1]);
            }
        }

        return new CardGame(players, cardDecks);

    }

    public static void main(String[] args) {
        CardGame game = createCardGame();
        game.playGame();
    }

}