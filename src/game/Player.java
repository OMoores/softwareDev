package game;
public class Player {
    private int cardValue;
    private CardDeck discardPile;
    private CardDeck takeFromPile;
    
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return this.cardValue;
    }

    public void setDiscardPile(CardDeck discardPile) {
        this.discardPile = discardPile;
    }

    public CardDeck getDiscardPile() {
        return this.discardPile;
    }

    public void setTakePile(CardDeck takeFromPile) {
        this.takeFromPile = takeFromPile;
    }

    public CardDeck getTakePile() {
        return this.takeFromPile;
    }


    public Player(int cardValue) {
        this.cardValue = cardValue;
    }
}
