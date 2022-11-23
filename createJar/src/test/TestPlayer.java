package test;

import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPlayer {

    // Tests that player is successfully created
    @Test
    public void testCreatePlayer() {
        Player player = new Player(1);
        assertNotNull(player);

    }

    @Test
    public void testAddCard() {
        Player player = new Player(1);

        // Testing addCard
        Card card1 = new Card(0);
        player.addCard(card1);
        assertEquals(player.getCards().getCards()[0].getCardValue(), 0);

    }

    // Tests getCardValue and setCardValue
    @Test
    public void testGetSetCardValue() {
        Player player = new Player(1);

        assertEquals(player.getCardValue(), 1);

        player.setCardValue(4);
        assertEquals(player.getCardValue(), 4);
    }

    // Tests getDiscardPile and setDiscardPile
    @Test
    public void testGetSetDiscardPile() {
        Player player = new Player(1);
        CardDeck discardDeck = new CardDeck();
        discardDeck.setNum(1);

        // Making sure discard pile starts as null
        assertNull(player.getDiscardPile());

        // Setting discard pile, making sure it has been set properly, isnt null and
        // getter works
        player.setDiscardPile(discardDeck);
        assertNotNull(player.getDiscardPile());
        assertEquals(player.getDiscardPile().getNum(), 1);

    }

    // Tests getTakePile and setTakePile
    @Test
    public void testGetSetTakePile() {
        Player player = new Player(1);
        CardDeck discardDeck = new CardDeck();
        discardDeck.setNum(1);

        // Making sure discard pile starts as null
        assertNull(player.getTakePile());

        // Setting discard pile, making sure it has been set properly, isnt null and
        // getter works
        player.setTakePile(discardDeck);
        assertNotNull(player.getTakePile());
        assertEquals(player.getTakePile().getNum(), 1);

    }

}
