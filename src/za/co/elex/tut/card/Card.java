package za.co.elex.tut.card;

public class Card implements  Comparable<Card>{
    private SUIT suit;
    private TYPE type;

    public Card(SUIT suit, TYPE type) {
        this.suit = suit;
        this.type = type;
    }

    public SUIT getSuit() {
        return suit;
    }

    public TYPE getType() {
        return type;
    }

    @Override
    public int compareTo(Card card) {

        if (suit != card.suit){
            return suit.ordinal() - card.suit.ordinal();
        }

        return type.ordinal() - card.type.ordinal();
    }

    @Override
    public String toString() {
        return type.getType() + " of " + suit.getSuit();
    }
}
