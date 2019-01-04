package com.bohra.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards = new ArrayList<>();
    private HandAnalyzer handAnalyzer = new HandAnalyzer();

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void buildHand(Deck deck){
        for (int n = 0 ; n < 5; n++ ){
            cards.add(deck.getRandomCard());
        }
    }

    public HandType getHandType() {
        return handAnalyzer.analyzeHand(this);
    }

    @Override
    public String toString() {
        String message = "Hand of " + cards.size() + " cards \r\n";
        for (Card card : cards) {
            message += card;
        }
        return message;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void resetHand(Deck deck) {
        deck.addCards(cards);
        cards.clear();
    }
}
