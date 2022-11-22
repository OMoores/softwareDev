package tests;

import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class testCard {

    // Tests that a card is created by making sure if not negative
    @Test
    public void testCreateCard() {
        assertNotNull(new Card(1));
    }

    // Tests that a cards value can be returned
    @Test
    public void testGetCardValue() {

        // Testing for multiple card values
        assertEquals(new Card(1).getCardValue(), 1);
        assertEquals(new Card(10000).getCardValue(), 10000);
    }

    public void testSetCardValue() {

        // Testing getting a card value, then setting it to a different one and checking
        // the value has changed

        Card card = new Card(2);
        assertEquals(card.getCardValue(), 2);
        card.setCardValue(5);
        assertEquals(card.getCardValue(), 5);
    }

}
