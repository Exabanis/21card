package com.texman.blackjack.model;

public record Card(SUIT suit, TYPE type) implements Comparable<Card> {
    @Override
    public int compareTo(Card card) {
        if (suit != card.suit) {
            return suit.ordinal() - card.suit.ordinal();
        }
        return type.ordinal() - card.type.ordinal();
    }

    @Override
    public String toString() {
        return type.getType() + " of " + suit.getSuit();
    }
}
