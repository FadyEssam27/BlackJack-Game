
package blackjack;


public class Player 
{
    public String player_name ; //player name variable
    public int score = 0; //score variable
    private Card[] cards_in_hand = new Card[11]; //array for cards in hand
    private int counter = 0;
    public boolean lost = false;
    
    public void addCard (Card paper)
    {
        if (counter < 11)
        {
            cards_in_hand[counter] = paper;
            counter ++;
            score+= paper.getValue();
        }
    }

    public Card[] getCards_in_hand() 
    {
        return this.cards_in_hand;
    }
    
}
