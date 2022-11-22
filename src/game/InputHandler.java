package game;

import java.util.Scanner;

public class InputHandler {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Checks if user input is valid
     * 
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
     * Gets player input for number of players in the game
     * 
     * @return
     */
    public static int getPlayerNum() {
        // NEED TO MAKE ABLE TO HANDLE STRINGS
        // Indicates if user input is valid
        Boolean validInput = false;
        int userNum = 0;

        // Takes user input and asseses if its valid
        while (!validInput) {
            System.out.println("How many players are in this card game?");
            userNum = scanner.nextInt();

            if (isValid(userNum)) {
                validInput = true;
            }
        }

        return userNum;
    }

    /**
     * Gets the path of a valid pack from the user
     */
    public static String getPackPath(int userNum) {

        // Asking user for valid pack and checks pack is valid
        Boolean validInput = false;
        String packPath = "";
        while (!validInput) {

            packPath = scanner.nextLine();
            System.out.println("Enter the path to a valid card pack");
            packPath = scanner.nextLine();

            // Checks if valid, if not asks for another to be entered
            if (FileHandler.checkValidPack(packPath, userNum)) {
                validInput = true;
                return packPath;
            } else {
                System.out.println("Pack either could not be found or was not valid, please enter another");
            }

        }

        return null;
    }
}
