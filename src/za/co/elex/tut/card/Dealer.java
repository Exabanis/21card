package za.co.elex.tut.card;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Person {
    private Deck deck;
    private Hand hand = new Hand();
    private int balance;

    public Dealer(Deck deck) {
        super("Dealer");
        this.deck = deck;
        this.balance = 100000;
        deck.shuffle();
    }

    public void hit() throws DeckDepltedException {
        hand.setHand(hitCard());
    }

    public Card hitCard() throws DeckDepltedException {
        return deck.draw();
    }

    public void deal(ArrayList<Player> players) throws DeckDepltedException {

        for (int i = 0; i < 2; i++){
            hit();
            for(Player player: players){
                player.hit();
            }
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public List<Card> getHand() {
        return hand.getHand();
    }

    public int getTotal() {
        return hand.handValue();
    }

    public void setHand() {
        this.hand = new Hand();
    }
}
