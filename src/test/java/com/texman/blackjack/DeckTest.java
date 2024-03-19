package com.texman.blackjack;

import com.texman.blackjack.model.Card;
import com.texman.blackjack.model.Deck;
import com.texman.blackjack.model.DeckDepltedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void getCards() {

    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        deck.shuffle();
        for(Card card : deck.getCards()){
            System.out.println(card);
        }
        System.out.println();

        deck.sort();
        for(Card card : deck.getCards()){
            System.out.println(card);
        }
    }

    @Test
    public void sort() {
    }

    @Test
    public void draw() throws DeckDepltedException {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.draw().toString());
    }
}
