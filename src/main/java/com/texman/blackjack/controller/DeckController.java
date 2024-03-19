package com.texman.blackjack.controller;

import com.texman.blackjack.model.Card;
import com.texman.blackjack.model.Deck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/v1/deck")
    public class DeckController {

        @GetMapping("/")
        public List<Card> getDeck(){
            Deck deck = new Deck();
            deck.shuffle();
            return deck.getCards();
        }
    }
