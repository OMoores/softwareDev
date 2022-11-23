package test;

import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAnyoneWon {

    // Tests if returns correct winner
    @Test
    public void testAnyoneWon() {
        // Has won
        Player player1 = new Player(1);
        Card card1 = new Card(1);
        Card card2 = new Card(1);
        Card card3 = new Card(1);
        Card card4 = new Card(1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        // Hasnt won
        Player player2 = new Player(1);
        Card card5 = new Card(2);
        Card card6 = new Card(1);
        Card card7 = new Card(1);
        Card card8 = new Card(1);
        player2.addCard(card5);
        player2.addCard(card6);
        player2.addCard(card7);
        player2.addCard(card8);

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        assertEquals(Player.anyoneWon(players), 0);
    }

    // Test with no winner
    @Test
    public void testAnyoneWonNoOne() {
        // Has won
        Player player1 = new Player(1);
        Card card1 = new Card(2);
        Card card2 = new Card(1);
        Card card3 = new Card(1);
        Card card4 = new Card(1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        // Hasnt won
        Player player2 = new Player(1);
        Card card5 = new Card(2);
        Card card6 = new Card(1);
        Card card7 = new Card(1);
        Card card8 = new Card(1);
        player2.addCard(card5);
        player2.addCard(card6);
        player2.addCard(card7);
        player2.addCard(card8);

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        // As no one should have won then returns -1
        assertEquals(Player.anyoneWon(players), -1);
    }

    // Tests where everyone has won, should return first winner
    @Test
    public void testAnyoneWonAll() {
        // Has won
        Player player1 = new Player(1);
        Card card1 = new Card(1);
        Card card2 = new Card(1);
        Card card3 = new Card(1);
        Card card4 = new Card(1);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        // Hasnt won
        Player player2 = new Player(1);
        Card card5 = new Card(1);
        Card card6 = new Card(1);
        Card card7 = new Card(1);
        Card card8 = new Card(1);
        player2.addCard(card5);
        player2.addCard(card6);
        player2.addCard(card7);
        player2.addCard(card8);

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        // Should return first player
        assertEquals(Player.anyoneWon(players), 0);
    }
}
