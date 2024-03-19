package com.texman.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    private Iterator<Card> nextCard;

    public Deck() {
        cards = new ArrayList<>();

        for (SUIT suit : SUIT.values()) {
            if (suit == SUIT.NONE) continue;
            for (TYPE type : TYPE.values()) {
                cards.add(new Card(suit, type));
            }
        }
        reset();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
        reset();
    }

    public void sort() {
        Collections.sort(cards);
        reset();
    }

    public Card draw() throws DeckDepltedException {
        if (nextCard.hasNext()) {
            return nextCard.next();
        }
        throw new DeckDepltedException();
    }

    private void reset() {
        nextCard = cards.iterator();
    }
}
