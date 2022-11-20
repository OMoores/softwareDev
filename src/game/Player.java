package game;
public class Player {
    private int cardValue;
    private CardDeck discardPile;
    private CardDeck takeFromPile;
    private CardDeck cards = new CardDeck();
    
    public CardDeck getCards() {
        return this.cards;
    }

    /**
     * Adds card to player card hand, to be used when setting up, not during game
     * @param card
     */
    public void addCard(Card card) {
        this.cards.addCard(card);
    }



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
