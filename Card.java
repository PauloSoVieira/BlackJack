package Mindera.Swap.BlackJack;

public class Card {


    private int value;
    private String suit;


    //Constructor


    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    //Getters
    public String getSuit() {
        return suit;
    }


    public int getValue() {
        return value;
    }


    public String text() {
        return this.getName() + " of " + suit;
    }

    public String getName() {

        switch (value) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(value);
        }
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}