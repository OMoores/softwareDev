package tests;

import game.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import game.InputHandler;

public class testIsValid {

    // Tests negative value, should return false for isValid
    @Test
    public void testNegative() {
        assertFalse(InputHandler.isValid(-100));
    }

    // Tests boundry values, 0 and 1, 0 should return false and 1 true for isValid
    @Test
    public void testBoundry() {
        assertFalse(InputHandler.isValid(0));
        assertTrue(InputHandler.isValid(1));
    }

    // Tests a large positive int for isValid
    @Test
    public void testPositive() {
        assertTrue(InputHandler.isValid(100));
    }

}