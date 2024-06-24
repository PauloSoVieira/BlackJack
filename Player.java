package Mindera.Swap.BlackJack;

public class Player {

   private String name;
   private int handValue = 0;
   private Card[] hand;
   private int cardReceived;


    public Player(String name) {
        this.name = name;
        this.hand = new Card[52];
        this.cardReceived = 0;


    }


    public void getCard(Card card) {
        if (card != null && cardReceived < hand.length) {
            hand[cardReceived++] = card;
        }
    }


    public int totalValue() {
        int value = 0;
        for (int i = 0; i < cardReceived; i++) {
            value += hand[i].getValue();

        }
        return value;
    }

    public void showCard(Deck deck) {
        while (totalValue() < 21) {
            Card card = deck.dealCard();
            getCard(card);
            //Gaurda carta no array incrementar +1
            System.out.println(name + "got " + card.getValue() + card.getSuit());
            System.out.println("total value : " + totalValue());

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
