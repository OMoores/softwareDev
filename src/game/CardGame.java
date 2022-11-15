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
            //Creating players and decks
            players[i] = new Player(i);
            cardDecks[i] = new CardDeck();
        }


        //Setting discard and take piles
        players[0].setTakePile(cardDecks[userNum-1]);
        players[0].setDiscardPile(cardDecks[0]);
        for (int i = 1; i < userNum; i++) {
            players[i].setTakePile(cardDecks[i-1]);
            players[i].setDiscardPile(cardDecks[i]);
        }

        
    }

    /**
     * Checks if user input is valid 
     * @param number
     * @return
     */
    public static Boolean isValid(int number) {
        if (number < 1) {
            return false;
        }

        return true;
    }

    /**
     * Returns a pack full of 8* number of players cards
     * @param numOfPlayers
     * @return
     */
    public static Card[] createCards(int numOfPlayers) {
        Card[] cardList = new Card[8*numOfPlayers];

        //Creating enough cards for the game
        for (int cardIndex = 0; cardIndex < (8*numOfPlayers); cardIndex++) {
            cardList[cardIndex] = new Card(cardIndex / numOfPlayers);
        }

        return cardList;
    }

    /**Creates cards and assigns their values based on the number of players input into function
     * @param numOfPlayers
     */
    /*public Card[] createCards(int noOfPlayers) {
    }*/
    
    public void run() {
        System.out.println("Thread");
    }


    public static void main(String[] args) {
      
    }

    
}