package za.co.elex.tut.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand {
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public int handValue(){
        Iterator<Card> nextCard = hand.iterator();
        boolean ace = hasAce(hand);
        int sum = 0;
        while(nextCard.hasNext()){
            sum += nextCard.next().getType().value();
        }
        if (ace == true && sum + 10 <= 21)
            return sum + 10;

        return sum;
    }

    private boolean hasAce(List<Card> hand) {
        Iterator<Card> nextCard = hand.iterator();
        while (nextCard.hasNext()){
            if (nextCard.next().getType().equals("Ace"))
                return true;
        }
        return false;
    }

    public void setHand(Card card) {
        this.hand.add(card);
    }
}
