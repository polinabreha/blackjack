package com.pluralsight;

import java.util.ArrayList;

public class Hand {
        private ArrayList<Card> cards;
        public Hand(){
            cards = new ArrayList<>();
        }
        public void deal(Card card){
            cards.add(card);
        }
        public int getSize(){
            return cards.size();
        }
    public int getValue() {

        int value = 0;
        int aceCount = 0;
        for (Card card : cards) {
            value += card.getPointValue();
            if (card.getValue().equals("A")) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }
        return value;
    }

}
