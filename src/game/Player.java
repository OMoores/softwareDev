package game;
public class Player implements Runnable {
    private int cardValue;
    private CardDeck discardPile;
    private CardDeck takeFromPile;
    private CardDeck cards = new CardDeck();
    
 
    public Player(int cardValue) {
        this.cardValue = cardValue;
    }

    /**
     * Thread simulates a players go
     */
    public void run() {
        //Discard a card => find which card they will discard
        Card discardCard = cards.findCardDiscard(this.cardValue);
            //Prints out what is discarded where
        System.out.println("Player " + cardValue + " has discarded a " + discardCard.getCardValue() + " to deck " + discardPile.getNum());
        discardPile.discardCard(discardCard);


        //Collect card 
        Card takenCard = takeFromPile.takeCard();
        cards.addCard(takenCard);
            //Prints out what is taken from where
        System.out.println("Player " + cardValue + " has taken a " + takenCard.getCardValue() + " to deck " + takeFromPile.getNum());


   

    }

    public synchronized CardDeck getCards() {
        return this.cards;
    }


    /**
     * Adds card to player card hand, to be used when setting up, not during game
     * @param card
     */
    public synchronized void addCard(Card card) {
        this.cards.addCard(card);
    }



    public synchronized void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public synchronized int getCardValue() {
        return this.cardValue;
    }

    public synchronized void setDiscardPile(CardDeck discardPile) {
        this.discardPile = discardPile;
    }

    public synchronized CardDeck getDiscardPile() {
        return this.discardPile;
    }

    public synchronized void setTakePile(CardDeck takeFromPile) {
        this.takeFromPile = takeFromPile;
    }

    public synchronized CardDeck getTakePile() {
        return this.takeFromPile;
    }

    /**
     * Checks if the player has won and returns boolean
     * @return
     */
    public synchronized Boolean hasWon() {
        //Flag represents if has found a card that isnt the same as the first in the players card list
        int cardType = cards.getCards()[0].getCardValue();
        for (int i = 1; i < 4; i++) {
            //If cards are not all the same type returns false
            if (cards.getCards()[i].getCardValue() != cardType) {
                return false;
            }
        }

        return true;
    }
}
