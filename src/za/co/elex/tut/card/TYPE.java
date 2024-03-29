package za.co.elex.tut.card;

public enum TYPE {
    TWO("2",2), THREE("3", 3), FOUR("4", 4),FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
    NINE("9", 9), TEN("10", 10), JACK("Jack", 10), QUEEN("Queen", 10), KING("King",10), ACE("Ace", 1);

    private String type;
    private int value;

    TYPE(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int value() {
        return value;
    }
}
