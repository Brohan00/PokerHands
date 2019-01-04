package com.bohra.poker;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Outcome {

    private Map<HandType, Integer> handsOfType = new TreeMap<>();
    private int total = 0;

    public void addResult(HandType handType){
        total++;
        int currentCount = 0;
        Integer count = handsOfType.get(handType);
        if (count == null){
            handsOfType.put(handType, 0);
        } else {
            currentCount = handsOfType.get(handType);
        }
        currentCount++;
        handsOfType.put(handType, currentCount);
    }

    public String toString() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(10);
        String message = "From " + total + " hands we have " + handsOfType.size() + " different hand types \r\n";
        for (Map.Entry<HandType, Integer> countOfHandType : handsOfType.entrySet()) {
            Integer count = countOfHandType.getValue();
            double percentage = (double) count / total;
            String formattedPercentage = numberFormat.format(percentage);
            message += countOfHandType.getKey() + " count = " + count + "  (" + formattedPercentage + ")\r\n";
        }
        return message;
    }
}
