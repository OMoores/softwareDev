package tests;

import game.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import game.InputHandler;

public class testHasWon {

    // Tests if a player with all of the same card has won, and if
    @Test
    public void testHasWon() {
        Player player1 = new Player(1);

        // Creates a player with cards of their type to check if has won
        Card card1 = new Card(1);
        Card card2 = new Card(1);
        Card card3 = new Card(1);
        Card card4 = new Card(1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);

        assertTrue(player1.hasWon());

        Player player2 = new Player(10);

        // Creates a player with cards of not their type to check if has won
        Card card5 = new Card(1);
        Card card6 = new Card(1);
        Card card7 = new Card(1);
        Card card8 = new Card(1);
        player2.addCard(card5);
        player2.addCard(card6);
        player2.addCard(card7);
        player2.addCard(card8);

        assertTrue(player2.hasWon());
    }

    // Test if has won returns false when player hasnt won
    @Test
    public void testHasWonFalse() {
        Player player1 = new Player(1);

        // Creates a player with cards of their type to check if has won
        Card card1 = new Card(3);
        Card card2 = new Card(1);
        Card card3 = new Card(1);
        Card card4 = new Card(1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);

        assertFalse(player1.hasWon());

    }

}
