package tests;
import game.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.*;


public class testCreateCards {
    
    //Tests to check all cards created by createCards are unique objects for 8 players
    @Test
    public void testUnique() {
        Card[] cardList = CardGame.createCards(8);

        //Checks that no card is the same object as any other card
        for (int i = 0; i < 7;i++) {
            for (int z = i+1;z < 8;z++) {
                assertNotSame(cardList[i], cardList[z]);
            }
        }
    }

    //Tests for a variety of lengths if the correct number of cards is genreated is the expected amount (8 * num of players)
    @Test
    public void testCorrectNumOfCards() {
     
        for (int i = 1;i < 100;i+=7) {
            Card[] cardList = CardGame.createCards(i);

            assertEquals(cardList.length, i*8);
        }
    }
}
