package game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CardGame implements Runnable {
    Player[] players;
    CardDeck[] cardDecks;

    /**
     * Constructor for new cardgame
     * @param playerNo - the number of players
     */
    public CardGame(Player[] players, CardDeck[] cardDecks) {
        this.players = players;
        this.cardDecks = cardDecks;
    }




    /**
     * Takes user input for number of players and creates card game
     * @param playerNo
     */
    public CardGame createCardGame(int playerNo) {
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

        //Asking user for valid pack and checks pack is valid
        validInput = false;
        String packPath = "";
        while (validInput) {

            System.out.println("Enter the path to a valid card pack");
            packPath = scanner.nextLine();

            //Checks if valid, if not asks for another to be entered
            if (checkValidPack(packPath, playerNo)) {
                validInput = true;
            } else {
                System.out.println("Pack either could not be found or was not valid, please enter another");
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

        Card[] cardList = getListFromPack(packPath, playerNo);
        //Filling in players cards 
        for (int i = 0; i < userNum; i++) {
            for (int playerIndex = 0; playerIndex < playerNo; playerIndex++) {
                players[playerIndex].addCard(cardList[i*playerNo + playerIndex]);
            }
        }

        //Filling in deck cards
        for (int i = 0; i < userNum; i++) {
            for (int deckIndex = 0; deckIndex < playerNo; deckIndex++) {
                //Fills in card decks, starting at the point in cardList that would have been emptied assigning cards to players
                cardDecks[deckIndex].addCard(cardList[i*playerNo + deckIndex + 4*playerNo - 1]);
            }
        }


        
        return new CardGame(players, cardDecks);
        
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
     * Checks that the file path input is a file that can be read and is a valid pack
     * May need to add something to check each player has enough cards to win
     * @param path
     * @return
     */
    public static Boolean checkValidPack(String path, int playerNum) {
        
        //Tries to read file 
        try {
            //Reading file
            File file = new File(path);
            Scanner reader = new Scanner(file);

            //Finds how many numbers in the 
            int lineNum = 0;

            //Goes through each line and checks contains a number
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                
                //If line does not contain number pack is invalid
                try  {
                    int num = Integer.parseInt(line);
                    lineNum++;
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            //Checks correct number of cards
            if (lineNum == 8*playerNum) {
                return true;
            }

            return false;


        } catch (FileNotFoundException e) {
            return false;

        }
    }
    
    /**
     * Gets a pack file and creates a list containing cards of the same value as the numbers in the pack file
     * @param path
     * @return
     */
    public static Card[] getListFromPack(String path, int playerNum) {
        Card[] list = new Card[8*playerNum];

        //Tries to read file 
        try {
            //Reading file
            File file = new File(path);
            Scanner reader = new Scanner(file);

            //Goes through file and adds card numbers to list
            for (int i = 0; i < playerNum*8;i++) {
                String line = reader.nextLine();
                
                //If line does not contain number pack is invalid
                try  {
                    //Creates a card and adds it to list
                    list[i] = new Card(Integer.parseInt(line));
                    
                } catch (NumberFormatException nf) {
                    throw nf;
                }
            }

            return list;


        } catch (FileNotFoundException fnf) {
            return null;
        }
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