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
                if (value .equals("A") ) {
                    return 11;
                }else if (value.equals("Q") || value.equals("J") || value.equals("K")){
                    return 10;
                }else if (value.equals("2")){
                    return 2;
                }else if (value.equals("3")){
                    return 3;
                }

            } else {
                return 0;
            }
            return getPointValue();
        }
        public boolean isFaceUp(){
            return isFaceUp;
        }
        public void flip(){
            isFaceUp = !isFaceUp;
        }

}
