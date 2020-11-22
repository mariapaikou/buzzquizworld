import java.util.ArrayList;

/**
 This class is initializing the players of the game and the number of rounds
also it makes a new type object.

 */

public class Game {
    int howManyPlayers=0;
    int howManyRounds=0;
    ArrayList <Player> playerList;
    Type type;

    public Game(){
        UserInteraction a = new UserInteraction();
        if(howManyPlayers>0 && howManyPlayers<=2) {
            playerList=new ArrayList<>();
            for (int i = howManyPlayers; i > 0; i--) {
                playerList.add(a.God());
            }
        }
    }

}
