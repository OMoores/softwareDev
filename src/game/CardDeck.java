package game;

public class CardDeck {
    Card[] cardList = new Card[5];
    int deckNum;

    public void CardDeck() {

    }

    public void discardCard(Card discardedCard) {
        cardList[3] = discardedCard;
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
        for (int i = 0; i < cardList.length; i++) {
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
        Boolean found = false;
        for (int i = 0; i < 4; i++) {
            if (cardList[i].getCardValue() != cardType && found == false) {
                card = cardList[i];
                found = true;
                // If card is not the last card move cards to fill empty position in list
                if (i != 3) {
                    cardList[i] = cardList[i + 1];
                    cardList[i + 1] = null;

                }

            } else if (found == true) {
                if (i != 3) {
                    cardList[i] = cardList[i + 1];
                    cardList[i + 1] = null;

                }
            }

        }

        return card;
    }

}
