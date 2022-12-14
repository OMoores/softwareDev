package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.xml.catalog.Catalog;
import java.io.BufferedWriter;

public class FileHandler {
    int player;
    int drawDeck;
    int discardDeck;
    File handlderFile;
    FileWriter writerFile;
    String path;

    /**
     * FileHandler constructor, each player has a file handler that automatically
     * writes results of play into a file
     */
    public FileHandler(int player, int drawDeck, int discardDeck) {
        this.player = player;
        this.drawDeck = drawDeck;
        this.discardDeck = discardDeck;

        try {
            this.path = "player" + this.player + "_output.txt";
            // Making sure file exists and is empty
            handlderFile = new File(path);
            handlderFile.delete();
            handlderFile.createNewFile();

            // Used to handle writing to file
            writerFile = new FileWriter(this.path);

        } catch (IOException e) {
            System.out.print(e);
        }

    }

    /**
     * Writes the players starting hand to file
     * 
     * @param hand
     */
    public void startingHand(int[] hand) {
        String strHand = "" + hand[0];

        for (int i = 1; i < hand.length; i++) {
            strHand += (" " + hand[i]);
        }

        try {
            // System.out.print(strHand);

            writerFile.write("Player " + player + " starting hand: " + strHand + "\n");
            // Saves to file and opens another file writer that appends to file
            writerFile.close();
            writerFile = new FileWriter(this.path, true);

        } catch (IOException e) {
            System.out.print(e);
        }
    }

    /**
     * Prints CardDeck to text file, only used for troubleshooting program
     * 
     * @param deck
     */
    public void printDeck(CardDeck cardDeck) {
        String deck = "Printing deck " + cardDeck.getNum() + ": ";
        for (int i = 0; i < 4; i++) {
            deck += cardDeck.getCards()[i].getCardValue() + " ";
        }

        try {
            writerFile.write(deck + "\n");
            // Saves to file and opens another file writer that appends to file
            writerFile.close();
            writerFile = new FileWriter(this.path, true);

        } catch (IOException e) {

        }

    }

    /**
     * Writes to file what card a player has drawn and from where
     * 
     * @param card
     */
    public void playerDraws(int card) {
        try {
            writerFile.write("Player " + player + " has taken a " + card + " from deck " + drawDeck + "\n");
            writerFile.close();
            writerFile = new FileWriter(this.path, true);

        } catch (IOException e) {
            System.out.print(e + "\n");
        }
    }

    /**
     * Writes to file what card a player has discarded and to where
     * 
     * @param card
     */
    public void playerDiscards(int card) {
        try {
            writerFile.write("Player " + player + " has discarded a " + card + " to deck " + discardDeck + "\n");
            writerFile.close();
            writerFile = new FileWriter(this.path, true);

        } catch (IOException e) {
            System.out.print(e + "\n");
        }
    }

    /**
     * Takes result of winner and writes appropriate message to file
     * 
     * @param winner
     */
    public void playerWins(int winner) {
        try {

            if (winner == player) {
                // For if the current player wins

                writerFile.write("Player " + player + " wins\n");
                writerFile.close();
                writerFile = new FileWriter(this.path, true);

            } else {
                // For if another player wins
                writerFile.write(
                        "Player " + winner + " has informed player " + player + " that player " + winner
                                + " has won\n");
                writerFile.close();
                writerFile = new FileWriter(this.path, true);
            }

            writerFile.close();

        } catch (IOException e) {
            System.out.print(e);
        }
    }

    /**
     * Writes to file that the player has exited the game
     */
    public void playerExits() {
        try {
            writerFile.write("Player " + player + " has left the game\n");
            writerFile.close();

        } catch (IOException e) {

        }
    }

    /**
     * Gets a pack file and creates a list containing cards of the same value as the
     * numbers in the pack file
     * 
     * @param path
     * @return
     */
    public static Card[] getListFromPack(String path, int playerNum) {
        Card[] list = new Card[8 * playerNum];

        // Tries to read file
        try {
            // Reading file
            File file = new File(path);
            Scanner reader = new Scanner(file);

            // Goes through file and adds card numbers to list
            for (int i = 0; i < playerNum * 8; i++) {
                String line = reader.nextLine();

                // If line does not contain number pack is invalid
                try {
                    // Creates a card and adds it to list
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

    /**
     * Checks that the file path input is a file that can be read and is a valid
     * pack
     * May need to add something to check each player has enough cards to win
     * 
     * @param path
     * @return
     */
    public static Boolean checkValidPack(String path, int playerNum) {

        // Tries to read file
        try {
            // Reading file
            File file = new File(path);
            Scanner reader = new Scanner(file);

            // Finds how many numbers in the
            int lineNum = 0;

            // Goes through each line and checks contains a number
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                // If line does not contain number pack is invalid
                try {
                    int num = Integer.parseInt(line);
                    lineNum++;
                } catch (NumberFormatException e) {
                    return false;
                }
            }

            // Checks correct number of cards
            if (lineNum == 8 * playerNum) {
                return true;
            }

            return false;

        } catch (FileNotFoundException e) {
            return false;

        }
    }
}
