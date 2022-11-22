package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.xml.catalog.Catalog;

public class FileHandler {
    int player;
    int drawDeck;
    int discardDeck;
    File handlderFile;
    FileWriter writerFile;

    /**
     * FileHandler constructor, each player has a file handler that automatically
     * writes results of play into a file
     */
    public FileHandler(int player, int drawDeck, int discardDeck) {
        this.player = player;
        this.drawDeck = drawDeck;
        this.discardDeck = discardDeck;

        try {

            // Making sure file exists and is empty
            handlderFile = new File("outputs/player" + this.player + "_output.txt");
            handlderFile.delete();
            handlderFile.createNewFile();

            // Used to andle writing to file
            writerFile = new FileWriter("outputs/player" + this.player + "_output.txt");

        } catch (IOException e) {

        }

    }

    /**
     * Writes the players starting hand to file
     * 
     * @param hand
     */
    public void startingHand(int[] hand) {
        try {
            writerFile.write("Player " + player + " starting hand: " + hand);
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
            writerFile.write("Player " + player + " has taken a " + card + " from deck " + drawDeck);

        } catch (IOException e) {

        }
    }

    /**
     * Writes to file what card a player has discarded and to where
     * 
     * @param card
     */
    public void playerDiscards(int card) {
        try {
            writerFile.write("Player " + player + " has discarded a " + card + " to deck " + discardDeck);

        } catch (IOException e) {

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
                writerFile.write("Player " + player + " wins");
            } else {
                // For if another player wins
                writerFile.write(
                        "Player " + winner + " has informed player " + player + " that player " + winner + " has won");
            }

        } catch (IOException e) {

        }
    }

    /**
     * Writes to file that the player has exited the game
     */
    public void playerExits() {
        try {
            writerFile.write("Player " + player + " has left the game");
        } catch (IOException e) {

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
