package com.texman.blackjack.model;

import lombok.Getter;
import java.util.List;

public class Player extends Person {
    private Hand hand = new Hand();
    private Dealer dealer;
    @Getter
    private int money;
    @Getter
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

    public void setMoney(int money) {
        this.money += money;
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
