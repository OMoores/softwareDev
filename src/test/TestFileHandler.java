package test;

import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testFileHandler {

    // Tests creating a file handler and assigning it to a player
    @Test
    public void testFileHandlerCreate() {
        // Creates player
        Player player = new Player(0);
        CardDeck takeFrom = new CardDeck();
        CardDeck discard = new CardDeck();
        player.setDiscardPile(discard);
        player.setTakePile(takeFrom);

        // Check doesnt have a file handler
        assertNull(player.getFileHandler());
        // Creates a file handler then checks it exists
        player.createFileHandler();
        assertNotNull(player.getFileHandler());
    }

    // Should create a file for the player and print the list of ints input
    @Test
    public void testStartingHand() {
        // Creates player
        Player player = new Player(0);
        CardDeck takeFrom = new CardDeck();
        CardDeck discard = new CardDeck();
        player.setDiscardPile(discard);
        player.setTakePile(takeFrom);
        player.createFileHandler();

        int[] list = { 1, 2, 3, 4 };

        assertNotNull(player.getFileHandler());
        // player.getFileHandler().startingHand(list);
    }

}
