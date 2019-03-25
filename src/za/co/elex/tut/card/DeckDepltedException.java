package za.co.elex.tut.card;

public class DeckDepltedException extends Exception {
    public DeckDepltedException() {
        super("All cards in deck depleted");
    }
}
