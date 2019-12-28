/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 *
 * @author Name : Riya Kumari
 * @version Date : Sept. 6
 * @author Period:5 APCS-A
 * @author Assignment: APCS Elevens Lab Activity 1
 *
 */
public class Card
{

    private String suit;

    private String rank;

    private int pointValue;


    /**
     * Creates a new <code>Card</code> instance.
     *
     * @param cardRank
     *            a <code>String</code> value containing the rank of the card
     * @param cardSuit
     *            a <code>String</code> value containing the suit of the card
     * @param cardPointValue
     *            an <code>int</code> value containing the point value of the
     *            card
     */
    public Card( String cardRank, String cardSuit, int cardPointValue )
    {
        this.rank = cardRank;
        this.suit = cardSuit;
        this.pointValue = cardPointValue;

    }


    /**
     * Accesses this <code>Card's</code> suit.
     * 
     * @return this <code>Card's</code> suit.
     */
    public String suit()
    {
        return suit;

    }


    /**
     * Accesses this <code>Card's</code> rank.
     * 
     * @return this <code>Card's</code> rank.
     */
    public String rank()
    {
        return rank;

    }


    /**
     * Accesses this <code>Card's</code> point value.
     * 
     * @return this <code>Card's</code> point value.
     */
    public int pointValue()
    {
        return pointValue;

    }

/**
 * Matches card with another card.
 * @param otherCard takes another card to compare the original card with
 * @return true if the card matches and false if it doesn't. 
 */
    public boolean matches( Card otherCard )
    {
        return suit == otherCard.suit && rank == otherCard.rank
                            && pointValue == otherCard.pointValue;
      
        
    }


    @Override
    public String toString()
    {
        String cardString = rank + " of " + suit + " (point value = " 
                            + pointValue + ")";
        return cardString;
    }
}
