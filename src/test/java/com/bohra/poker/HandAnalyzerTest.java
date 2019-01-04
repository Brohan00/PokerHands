package com.bohra.poker;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandAnalyzerTest {

    private HandAnalyzer handAnalyzer = new HandAnalyzer();

    @Test
    public void testBroken (){
        Hand hand = buildTestHand(
                new Card(0, 0),
                new Card(1, 0),
                new Card(2, 0),
                new Card(3, 0),
                new Card(5, 1)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.BROKEN_HAND);

    }

    @Test
    public void testOnePair (){
        Hand hand = buildTestHand(
                new Card(0, 0),
                new Card(1, 0),
                new Card(2, 0),
                new Card(1, 2),
                new Card(5, 1)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.ONE_PAIR);
    }

    @Test
    public void testTwoPair (){
        Hand hand = buildTestHand(
                new Card(0, 0),
                new Card(5, 1),
                new Card(5, 0),
                new Card(2, 0),
                new Card(0, 3)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.TWO_PAIR);
    }

    @Test
    public void testThreeOfAKind (){
        Hand hand = buildTestHand(
                new Card(8, 0),
                new Card(4, 0),
                new Card(8, 3),
                new Card(8, 1),
                new Card(3, 0)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.THREE_OF_A_KIND);
    }

    @Test
    public void testStraight (){
        Hand hand = buildTestHand(
                new Card(0, 2),
                new Card(4, 0),
                new Card(3, 3),
                new Card(1, 1),
                new Card(2, 1)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.STRAIGHT);
    }

    @Test
    public void testFlush (){
        Hand hand = buildTestHand(
                new Card(9, 0),
                new Card(11, 0),
                new Card(6, 0),
                new Card(5, 0),
                new Card(2, 0)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.FLUSH);
    }

    @Test
    public void testFullHouse (){
        Hand hand = buildTestHand(
                new Card(12, 0),
                new Card(12, 1),
                new Card(5, 2),
                new Card(12, 3),
                new Card(5, 1)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.FULL_HOUSE);
    }

    @Test
    public void testFourOfAKind (){
        Hand hand = buildTestHand(
                new Card(12, 0),
                new Card(12, 2),
                new Card(4, 1),
                new Card(12, 3),
                new Card(12, 1)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void testStraightFlush (){
        Hand hand = buildTestHand(
                new Card(4, 0),
                new Card(5, 0),
                new Card(6, 0),
                new Card(7, 0),
                new Card(8, 0)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.STRAIGHT_FLUSH);
    }

    @Test
    public void testRoyalFlush (){
        Hand hand = buildTestHand(
                new Card(9, 0),
                new Card(11, 0),
                new Card(12, 0),
                new Card(8, 0),
                new Card(10, 0)
        );

        HandType handType = handAnalyzer.analyzeHand(hand);
        Assert.assertTrue(handType == HandType.ROYAL_FLUSH);
    }

    private Hand buildTestHand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive) {
        List<Card> testList = new ArrayList<>();
        testList.add(cardOne);
        testList.add(cardTwo);
        testList.add(cardThree);
        testList.add(cardFour);
        testList.add(cardFive);

        Hand hand = new Hand();
        hand.setCards(testList);

        System.out.println(hand);
        return hand;
    }

}
