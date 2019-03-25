package za.co.elex.tut.card;

public enum SUIT {

    NONE(""), CLUBS("Clubs"), HEARTS("Hearts"), DIAMONDS("Diamonds"), SPADE("Spade");

    private String suit;

    SUIT(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
