package za.co.elex.tut.card;

import java.util.Iterator;
import java.util.List;

public class Player extends Person {
    private Hand hand = new Hand();
    private Dealer dealer;
    private int money;
    private int bet;

    public Player(String name, int money) {
        super(name);
        this.money = money;
    }

    public List<Card> getHand() {
        return hand.getHand();
    }

    public void hit() throws DeckDepltedException {
        hand.setHand(dealer.hitCard());
    }

    public void setHand() {
        this.hand = new Hand();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        if (bet <= money)
            this.bet = bet;
        else
            this.bet = money;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public int getTotal() {
        return hand.handValue();
    }

}
