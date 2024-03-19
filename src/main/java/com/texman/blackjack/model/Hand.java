package com.texman.blackjack.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class Hand {
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public int handValue(){
        Iterator<Card> nextCard = hand.iterator();
        boolean ace = hasAce(hand);
        int sum = 0;
        while(nextCard.hasNext()){
            sum += nextCard.next().type().value();
        }
        if (ace && sum + 10 <= 21) {
            return sum + 10;
        }
        return sum;
    }

    private boolean hasAce(List<Card> hand) {
        for (Card card : hand) {
            if (card.type().equals("Ace"))
                return true;
        }
        return false;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }
}