
package blackjack;


public class Card 
{
    //card variables
    private final int suit;
    private final int rank;
    private final int value;
    
    //parameterized constructor
    public Card(int suit, int rank, int value)
    {
    this.suit = suit;
    this.rank = rank;
    this.value = value;
    }
    //copy constructor
    public Card(Card paper)
    {
    this.suit = paper.suit;
    this.rank = paper.rank;
    this.value = paper.value;
    }

    //getter functions
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
}
