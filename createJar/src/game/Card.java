package game;

public class Card {

    private int cardValue;

    /**
     * Constructor for card, parameter is the card value of the card
     * 
     * @param cardValue
     */
    public Card(int cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardValue(int value) {
        this.cardValue = value;
    }

    public int getCardValue() {
        // REMOVE TRY CATCH
        try {
            return this.cardValue;
        } catch (Error e) {
            return -10;
        }

    }

}
