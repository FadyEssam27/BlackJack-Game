package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game 
{
    public Player[] participants = new Player[4]; //array for participated players
    public Card[] card_deck = new Card [52]; //array fot card deck
    public int[] players_highscores = new int [4]; //array to save the high score for every player
    
    //Generate Function
    public void generate ()
    {
        int c = 0;    
        for ( int x = 0; x <4; x++)
        {
            for (int y = 0; y <13; y++)
            {
                int value = (y >= 10) ? 10 : y+1 ;
                Card paper = new Card(x,y, value) ;
                card_deck[c] = paper;
                c++;
            }
    
        }
    }
    //Draw Function
    public Card draw()
    {
        Random random = new Random();
        Card paper = null ;
        do {
        int randnum = random.nextInt (51);
        paper = card_deck[randnum];
        card_deck[randnum] = null;
        }while (paper == null);
        return paper;
    }
    public void setData()
    {
    Scanner scanner = new Scanner (System.in);
        for (int x = 0; x < participants.length; x++)
        {
            System.out.println("Enter name of player" + (x+1) + ":");
            participants[x] = new Player();
            participants[x].player_name = scanner.next();
            participants[x].addCard(this.draw());
            participants[x].addCard(this.draw());
        }
            participants[3] = new Player();
            participants[3].player_name = "Dealer";
            participants[3].addCard(this.draw());
            participants[3].addCard(this.draw());
    }
    public void GameScoreUpdate ()
    {
        for (int x = 0; x<players_highscores.length; x++)
        {
            players_highscores [x] = participants[x].score <= 21? participants[x].score : 0;
        }
            
    }
}
