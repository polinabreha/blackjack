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
        public int getValue(){
            int value = 0;
            for(Card card: cards){
                card.flip(); // turn the card over to see the value
                value += card.getPointValue();
                card.flip(); // hide the card again
            }
            return value;
        }

}
