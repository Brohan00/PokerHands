import com.bohra.poker.Deck;
import com.bohra.poker.Hand;
import com.bohra.poker.HandType;
import com.bohra.poker.Outcome;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Deck deck = new Deck();
        Hand hand = new Hand();
        Outcome outcome = new Outcome();
        int runs = 1000000000;
        int increment = runs / 100;
        for (int count = 0; count < runs; count ++){
            if (count % increment == 0 && count > 5){
                System.out.printf("completed " + count + " of " + runs + "\r\n");
            }
            hand.buildHand(deck);
            HandType handType = hand.getHandType();
            outcome.addResult(handType);
            hand.resetHand(deck);
        }
        System.out.println(outcome);
    }
}
