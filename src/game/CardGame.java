package game;
import java.util.Scanner;

public class CardGame implements Runnable {
    Player[] players;
    CardDeck[] cardDecks;

    /**
     * Constructor for new cardgame
     * @param playerNo - the number of players
     */
    public CardGame(int playerNo) {
        
    }

    /**
     * Takes user input for number of players and creates card game
     * @param playerNo
     */
    public void createCardGame(int playerNo) {
        Scanner scanner = new Scanner(System.in);

        //Indicates if user input is valid
        Boolean validInput = false;
        int userNum = 0;

        //Takes user input and asseses if its valid
        while (!validInput) {
            System.out.println("How many players are in this card game?");
            userNum = scanner.nextInt();

            if (isValid(userNum)) {
                validInput = true;
            }
        }

        //Creating lists to hold players and card decks
        Player[] players = new Player[userNum];
        CardDeck[] cardDecks = new CardDeck[userNum];

        //Creating players and decks
        for (int i = 0; i < userNum; i++) {
            //Creating players and setting take and discard pile
            players[i] = new Player(i);
            cardDecks[i] = new CardDeck();
            players[i].setTakePile(cardDecks[i]);
            
            if (i == userNum - 1) {
                players[i].setDiscardPile(cardDecks[0]);
            } else {
                players[i].setDiscardPile(cardDecks[i+1]);
            }
        }
    }

    /**
     * Checks if user input is valid 
     * @param number
     * @return
     */
    public Boolean isValid(int number) {
        if (number < 1) {
            return false;
        }

        return true;
    }
    
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String[] args) {
      
    }

    
}