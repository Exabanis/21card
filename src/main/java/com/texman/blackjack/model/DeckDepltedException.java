package com.texman.blackjack.model;

public class DeckDepltedException extends Exception {
    public DeckDepltedException() {
        super("All cards in deck depleted");
    }
}
