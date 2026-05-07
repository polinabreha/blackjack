package com.pluralsight;

public class Card {
        private String suit;
        private String value;
        private boolean isFaceUp;
        public Card(String suit, String value) {
            this.suit = suit;
            this.value = value;
            this.isFaceUp = false;
        }
        public String getSuit(){
            if(isFaceUp){
                return suit;
            } else {
                return "#";
            }
        }
        public String getValue(){
            if(isFaceUp){
                return value;
            } else {
                return "#";
            }
        }
        public int getPointValue(){
            if (isFaceUp) {
                switch (value) {
                    case "A" -> {
                        return 11;
                    }
                    case "Q", "J", "K" -> {
                        return 10;
                    }
                    case "2" -> {
                        return 2;
                    }
                    case "3" -> {
                        return 3;
                    }case "4" -> {
                        return 4;
                    }
                    case "5" -> {
                        return 5;
                    }case "6" -> {
                        return 6;
                    }case "7" -> {
                        return 7;
                    }case "8" -> {
                        return 8;
                    }case "9" -> {
                        return 9;
                    }case "10" -> {
                        return 10;
                    }default -> {
                        return Integer.parseInt(value);
                    }
                }

            } else {
                return 0;
            }
        }
        public boolean isFaceUp(){
            return isFaceUp;
        }
        public void flip(){
            isFaceUp = !isFaceUp;
        }

}
