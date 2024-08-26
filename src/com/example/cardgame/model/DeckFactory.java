package com.example.cardgame.model;

public class DeckFactory {
    public enum DeckType {
        normal,
        small,
        test
    };

    public static Deck makeDeck(DeckType type){
        switch(type){
            case small: return new SmallDeck();
            case normal: return new NormalDeck();
            case test: return new TestDeck();
        }

        return new NormalDeck();
    }

}
