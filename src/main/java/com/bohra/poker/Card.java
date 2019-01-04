package com.bohra.poker;

public class Card {

    private int rank;
    private int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public String rankAsString() {
        if (rank < 9){
            return Integer.toString(rank + 2);
        }
        switch (rank){
            case 9:
                return "Jack";
            case 10:
                return "Queen";
            case 11:
                return "King";
            case 12:
                return "Ace";
            default:
                return "unknown";
        }
    }

    public String suitAsString(){
        switch (suit){
            case 0:
                return "Spades";
            case 1:
                return "Hearts";
            case 2:
                return "Clubs";
            case 3:
                return "Diamonds";
            default:
                return "unknown";
        }
    }
    public String toString() {
        return rankAsString() + " of " + suitAsString() + "\r\n";
    }
}
