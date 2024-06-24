package Mindera.Swap.BlackJack;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;
    private int turn;

    public Game() {
        deck = new Deck();
        deck.init();
        deck.shuffle();
    }

    public void startGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        turn = 1;

        System.out.println("Turn " + turn + ":");

        // Deal initial cards
        dealInitialCards(player1);
        dealInitialCards(player2);

        // Players take turns to draw cards
        while (true) {
            if (playerTurn(player1)) {
                break;
            }
            if (playerTurn(player2)) {
                break;
            }
        }

        // Determine the winner
        determineWinner();

        // Shuffle the deck for the next game
        shuffleDeck();
    }

    private void dealInitialCards(Player player) {
        for (int i = 0; i < 2; i++) {
            Card card = deck.dealCard();
            player.getCard(card);
            System.out.println(player.getName() + " got " + card.text());
        }
        System.out.println(player.getName() + "'s hand value = " + player.totalValue());
    }

    private boolean playerTurn(Player player) {

        //Increment turns
        turn++;
        System.out.println("\nTurn " + turn + ": " + player.getName() + "'s turn");

        while (player.totalValue() < 21) {
            Card card = deck.dealCard();
            player.getCard(card);
            System.out.println(player.getName() + " got " + card.text());
            System.out.println(player.getName() + "'s hand value = " + player.totalValue());

            if (player.totalValue() == 21) {
                System.out.println("\n" + player.getName() + " reaches 21 and wins!");
                return true;
            } else if (player.totalValue() > 21) {
                System.out.println("\n" + player.getName() + " exceeds 21 and loses!");
                return true;
            }
            return false;
        }
        return true;
    }

    private void determineWinner() {
        int player1Value = player1.totalValue();
        int player2Value = player2.totalValue();

        System.out.println("\nPlayer 1's final value: " + player1Value);
        System.out.println("Player 2's final value: " + player2Value);

        if (player1Value > 21 && player2Value > 21) {
            System.out.println("Both players bust. It's a tie!");
        } else if (player1Value > 21) {
            System.out.println("Player 2 wins!");
        } else if (player2Value > 21) {
            System.out.println("Player 1 wins!");
        } else if (player1Value > player2Value) {
            System.out.println("Player 1 wins!");
        } else if (player2Value > player1Value) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private void shuffleDeck() {
        deck.shuffle();
        System.out.println("Deck shuffled for the next game.");
    }
}
