package com.bohra.poker;

import java.util.*;

public class HandAnalyzer {

    public HandType analyzeHand(Hand hand) {
        HandType retVal;
        List<Card> sortedCards = new ArrayList<>(hand.getCards());
        sortedCards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return Integer.compare(c1.getRank(), c2.getRank());
            }
        });
        boolean foundFlush = isFlush(sortedCards);
        boolean foundStraight = isStraight(sortedCards);
        HandType streakRank = getStreakRank(sortedCards);
        if (foundFlush && foundStraight) {
            retVal = HandType.STRAIGHT_FLUSH;
            if(sortedCards.get(0).getRank() == 8) {
                retVal = HandType.ROYAL_FLUSH;
            }
        } else if (foundFlush) {
            retVal = HandType.FLUSH;
        } else if (foundStraight) {
            retVal = HandType.STRAIGHT;
        } else {
            retVal = streakRank;
        }
        return retVal;
    }

    private HandType getStreakRank(List<Card> sortedCards) {
        List<Integer> rankStreakLengths = getRankStreakLengths(sortedCards);
        Integer firstStreakLength = rankStreakLengths.get(0);
        Integer secondStreakLength = rankStreakLengths.get(1);
        if (firstStreakLength == 4) {
            return HandType.FOUR_OF_A_KIND;
        } else if (firstStreakLength == 3) {
            if (secondStreakLength == 2) {
                return HandType.FULL_HOUSE;
            } else {
                return HandType.THREE_OF_A_KIND;
            }
        } else {
            if (firstStreakLength == 2) {
                if (secondStreakLength == 2) {
                    return HandType.TWO_PAIR;
                } else {
                    return HandType.ONE_PAIR;
                }
            }
        }
        return HandType.BROKEN_HAND;
    }

    private List<Integer> getRankStreakLengths(List<Card> sortedCards) {
        List<Integer> rankStreakLengths = new ArrayList<>();
        int targetRank = sortedCards.get(0).getRank();
        int streakLength = 1;
        int index = 1;
        while (index < 5) {
            Card testCard = sortedCards.get(index);
            if (testCard.getRank() == targetRank) {
                streakLength++;
            } else {
                rankStreakLengths.add(streakLength);
                streakLength = 1;
                targetRank = sortedCards.get(index).getRank();
            }
            index++;
        }
        rankStreakLengths.add(streakLength);
        rankStreakLengths.sort(Collections.reverseOrder());
        return rankStreakLengths;
    }

    private boolean isFlush(List<Card> cards) {
        int suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight(List<Card> cards) {
        int rank = cards.get(0).getRank();
        for (int d = 0; d <= 4; d++) {
            if (cards.get(d).getRank() - rank != d) {
                return false;
            }
        }
        return true;
    }
}
