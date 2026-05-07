package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        greeting();

        boolean run = true;
        while (run) {
            System.out.println("Following options: ");
            System.out.println("1. Start game");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    ArrayList<String> playerNames = getPlayers(input);
                    startGame(playerNames);
                    break;
                case 2:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void greeting(){
        System.out.println("=========================================================");
        System.out.println("==============Welcome at the BlackJack Game =============");
        System.out.println("=========================================================");
    }

    public static ArrayList<String> getPlayers(Scanner input) {
        int numPlayers = 0;

        while (numPlayers < 2 || numPlayers > 5) {
            System.out.print("How many players? (2-5): ");
            numPlayers = input.nextInt();
            input.nextLine();
            if (numPlayers < 2 || numPlayers > 5) {
                System.out.println("Invalid. Please enter between 2 and 5.");
            }
        }

        ArrayList<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            playerNames.add(input.nextLine());
        }

        return playerNames;
    }

    public static ArrayList<Hand> startGame(ArrayList<String> playerNames) {
        ArrayList<Hand> hands = new ArrayList<>();
        Deck deck = new Deck();
        for (int i = 0; i < playerNames.size(); i++) {
            Hand hand = new Hand();

            for (int j = 0; j < 2; j++) {
                Card card = deck.deal();
                card.flip();
                hand.deal(card);
            }

            hands.add(hand);

            System.out.println(playerNames.get(i) + " ----> " + hands.get(i).getValue() );
        }

        int highestValue = 0;
        String winner = "";
        for (int i = 0; i < playerNames.size(); i++) {
            if (hands.get(i).getValue() > 21)  {
                continue;
            }else if (highestValue < hands.get(i).getValue()) {
                highestValue = hands.get(i).getValue();
                winner = playerNames.get(i);
            }
        }
        if (winner.isEmpty()) {
            System.out.println("Everyone busted! No winner.");
        } else {
            System.out.println("The winner is: " + winner);
        }
        return hands;
    }
}
