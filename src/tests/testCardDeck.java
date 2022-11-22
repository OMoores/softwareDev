package tests;

import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testCardDeck {

    // Tests creating a CardDeck
    @Test
    public void testCreateCardDeck() {
        CardDeck deck = new CardDeck();

        assertNotNull(deck);
    }

    // Tests getNum and setNum
    @Test
    public void testSetGetNum() {
        CardDeck deck = new CardDeck();
        // Sets num twice and checks if the num is the correct value
        deck.setNum(1);
        assertEquals(deck.getNum(), 1);
        deck.setNum(5);
        assertEquals(deck.getNum(), 5);
    }

    // Test adding cards to a deck until it is full
    @Test
    public void testAddGetCards() {
        // Creates a deck and fills it with cards
        Card card1 = new Card(0);
        Card card2 = new Card(1);
        Card card3 = new Card(2);
        Card card4 = new Card(3);
        CardDeck deck = new CardDeck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        deck.addCard(card4);

        Card[] cards = deck.getCards();

        // Checks that the deck is filled with cards of the correct value
        for (int i = 0; i < 4; i++) {
            assertEquals(cards[i].getCardValue(), i);
        }

    }

    // Tests takeCard by creating a deck and taking cards from it until its empty
    @Test
    public void testTakeCard() {
        // Creates a deck and fills it with cards
        Card card1 = new Card(0);
        Card card2 = new Card(1);
        Card card3 = new Card(2);
        Card card4 = new Card(3);
        CardDeck deck = new CardDeck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        deck.addCard(card4);

        // Checks every card is the correct value and every taken card is null
        for (int i = 0; i < 4; i++) {
            assertEquals(deck.takeCard().getCardValue(), i);
            for (int z = 0; z < i + 1; z++) {
                assertNull(deck.getCards()[4 - z]);
            }
        }

    }

    @Test
    public void testFindCardDiscard() {
        // Creates a deck and fills it with cards
        Card card1 = new Card(0);
        Card card2 = new Card(1);
        Card card3 = new Card(2);
        Card card4 = new Card(3);
        CardDeck deck = new CardDeck();
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        deck.addCard(card4);

        // Should return card 1 and remove it from list
        assertEquals(deck.findCardDiscard(0).getCardValue(), 1);
        // Testing to check that the card has been removed from list
        assertEquals(deck.getCards()[0].getCardValue(), 0);
        assertNull(deck.getCards()[3]);

        // should return card 0 and remove it from the middle of the list
        assertEquals(deck.findCardDiscard(2).getCardValue(), 0);
        assertNull(deck.getCards()[2].getCardValue());
        assertEquals(deck.getCards()[1].getCardValue(), 3);

    }

}
