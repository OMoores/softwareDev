package game;
public class CardDeck {
    Card[] cardList = new Card[4];

    public void discardCard(Card discardedCard) {
        cardList[3] = discardedCard;
    }

    /**
     * Returns card from top of deck and removes it from deck
     * @return
     */
    public Card takeCard() {
        Card card = cardList[0];

        //Moves all items in list up one
        for (int i = 0; i < 3;i++) {
            cardList[i] = cardList[i+1];
            cardList[i+1] = null;
        }

        return card;
    }

    public void addCard(Card card) {
        for (int i = 0; i < 4; i++) {
            if (cardList[i] == null) {
                cardList[i] = card;
                return;
            }
        }
    }
    
}
