package com.texman.blackjack.model;

import lombok.Getter;

@Getter
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }
}
