package game;

public class CardDeck {
    Card[] cardList = new Card[5];
    int deckNum;

    public void CardDeck() {

    }

    public void discardCard(Card discardedCard) {

        for (int i = 0; i < 4; i++) {
            if (cardList[i] == null) {
                cardList[i] = discardedCard;
            }
        }

    }

    public void setNum(int deckNum) {
        this.deckNum = deckNum;
    }

    public int getNum() {
        return this.deckNum;
    }

    /**
     * Returns card from top of deck and removes it from deck
     * 
     * @return
     */
    public synchronized Card takeCard() {
        Card card = cardList[0];

        // Moves all items in list up one
        for (int i = 0; i < cardList.length - 1; i++) {
            cardList[i] = cardList[i + 1];
            cardList[i + 1] = null;
        }

        return card;
    }

    public synchronized void addCard(Card card) {
        for (int i = 0; i < cardList.length; i++) {
            if (cardList[i] == null) {
                cardList[i] = card;
                return;
            }
        }
    }

    public synchronized Card[] getCards() {
        return this.cardList;
    }

    /**
     * Finds the first card that isnt the card type the player is looking for,
     * removes it from the deck and returns
     */
    public synchronized Card findCardDiscard(int cardType) {

        Card card = new Card(1);

        // Find first card that isnt of card type
        for (int i = 0; i < cardList.length; i++) {
            // Finds first card that isnt of the cardType is returned
            if (cardList[i].getCardValue() != cardType) {
                card = cardList[i];
                cardList[i] = null;
                // Moves cards up after the one that has been removed
                for (int z = i; z < 4; z++) {
                    cardList[z] = cardList[z + 1];
                    cardList[z + 1] = null;
                }

                return card;

            }

        }
        // Move up all other cards
        // Return card

        return card;

    }

}
