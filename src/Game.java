import java.util.ArrayList;

/**
 This class is initializing the players of the game and the number of rounds
also it makes a new type object.

 */

public class Game {
    private int howManyPlayers;
    private int howManyRounds;
    private ArrayList <Player> playerList;
    private Type type;
/**
 * Constructor
 */
    public Game(){
        UserInteraction a = new UserInteraction();
        howManyPlayers = a.HowManyOfYou();
        howManyRounds = a.HowManyRounds();
        String nameOfType = a.TypeOfGame();

        playerList=new ArrayList<>();
        for (int i = howManyPlayers; i > 0; i--) {
            playerList.add(a.God());
        }
        type = new Type(nameOfType);
    }

}
