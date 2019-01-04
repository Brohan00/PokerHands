package com.bohra.poker;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> fullDeck = new ArrayList<>();

    public Deck() {
        buildDeck();
    }

    public void buildDeck() {
        fullDeck.clear();
        for (int s = 0; s < 4; s++){
            for (int r = 0; r < 13 ; r++){
                fullDeck.add(new Card(r, s));
            }
        }
    }

    @Override
    public String toString() {
        String message = "Deck of " + fullDeck.size() + " cards \r\n";
        for (Card card : fullDeck) {
            message += card;
        }
        return message;
    }

    public Card getRandomCard() {
        int randomCardPos = (int) (Math.random() * fullDeck.size());
        return fullDeck.remove(randomCardPos);
    }

    public void addCards(List<Card> cards) {
        fullDeck.addAll(cards);
    }
}
