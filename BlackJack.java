
package blackjack;

import java.util.Scanner;


public class BlackJack {
    static Game game = new Game();
    public static void main(String[]args)
    {
        GUI gui = new GUI();
        
        game.generate();
        game.setData();
        gui.runGUI(game.card_deck,
                    game.participants[0].getCards_in_hand(),
                    game.participants[1].getCards_in_hand(),
                    game.participants[2].getCards_in_hand(),
                    game.participants[3].getCards_in_hand());
        participabtsTurn(gui);
        game.GameScoreUpdate();
        
        dealersTurn(gui);
        game.GameScoreUpdate(); 
        
        checkGame ();
                
    }
    public static void participabtsTurn(GUI gui)
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        for (int x=0 ;x <game.participants.length -1 ;x++)
        {

            while(!input.toLowerCase().equals("stand")){
                System.out.println("Player no " + (x+1) +"{Hit/Stand}");
                input = scanner.next();
                if (input.toLowerCase().equals("hit")){
                    addCardToPlayer(x,gui);
                    if(game.participants[x].score == 21){
                        break;
                    }else if (game.participants[x].score > 21){
                        game.participants[x].lost = true;
                        break;
                    }
                }
            }
        }
    }
    public static void addCardToPlayer(int index , GUI gui )
    {
        Card card = game.draw();
        game.participants[ index ].addCard(card);
        gui.updatePlayerHand(card,index);
    }
    
    public static void dealersTurn(GUI gui)
    {
        boolean dealerWins = true;
        int highscore = 0;
        for (int x = 0; x< game.participants.length -1 ; x++)
        {
            if (game.players_highscores[x] >= game.participants[3].score)
            {
                dealerWins = false;
            }
            if (game.players_highscores[x] > highscore)
            {
                highscore = game.players_highscores[x];
            }
        }
        if (!dealerWins )
        {
            addCardToDealer(gui, highscore);
        }
        else 
        {
            return;
        }
    }

    public static void addCardToDealer(GUI gui, int highscore) {
        while(game.participants[3].score < highscore)
        {
            Card paper = game.draw();
            game.participants[3].addCard(paper);
            gui.updateDealerHand(paper , game.card_deck);
        }

    }
    public static void checkGame()
    {
        int highscore = 0;
        int winner = -1;
        int winners = 0;
        for (int x=0 ; x < game.participants.length ; x++)
        {
            if (game.players_highscores[x] > highscore)
            {
                highscore = game.players_highscores[x];
                winner = x;
                winners++;
            }
        }
        if (winners == 1)
        {
            System.out.println("The winner is " + game.participants[winner].player_name + " with score : " + highscore);
        }else{
            System.out.println("PUSH");
        }
    }
    
}
