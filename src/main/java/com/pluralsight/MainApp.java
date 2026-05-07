package com.pluralsight;

public class MainApp {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();

        for(int i = 0; i < 5; i++) {
            Card card = deck.deal();
            hand1.deal(card);
        }
        int handValue = hand1.getValue();
        System.out.println("This hand is worth " + handValue);
    }
}
