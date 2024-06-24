package Mindera.Swap.BlackJack;

import java.util.Arrays;
import java.util.Random;



//TODO mudar para arraylist


public class Deck {
    private final Random random = new Random();
    private Card[] cards;
    private int indexCard;
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private String[] figure = {"Diamonds", "Spades", "Hearts", "Clubs"};

    public void init() {
        // Creating the deck
        cards = new Card[52];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < figure.length; j++) {
                cards[index] = new Card(numbers[i], figure[j]);
               // System.out.println(cards[index].getName());
                index++;
            }
        }
    }

    public void shuffle() {
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(n);
            // Swap cards
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
        System.out.println(Arrays.toString(cards));
        //After shuffle deck to reset
        indexCard = 0;
    }

    public Card dealCard() {
        if (indexCard >= cards.length) {
            this.shuffle();
        }
        return cards[indexCard++];
    }
}
