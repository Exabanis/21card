package com.texman.blackjack.model;

import lombok.Getter;

@Getter
public enum SUIT {

    NONE(""), CLUBS("Clubs"), HEARTS("Hearts"), DIAMONDS("Diamonds"), SPADE("Spade");

    private final String suit;

    SUIT(String suit) {
        this.suit = suit;
    }

}
