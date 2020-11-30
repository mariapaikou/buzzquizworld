import java.util.ArrayList;

/**
 * This class is initializing the players of the game also it makes a new round object.
 */

public class Game {
    /**
     * @param playerList is an ArrayList that stores Player objects
     * @param
     */
    //private int howManyPlayers;
    //private Type type;
    private ArrayList <Player> playerList;
    private static int howManyRounds = 5;
    //edw tha ftiaxnoyme kai ena antikeimeno Round to opoio tha analabei thn Type kai tis erwthseis


/**
 * Constructor
 */
    public Game(){

        UserInteraction a = new UserInteraction();
       // howManyPlayers = a.HowManyOfYou();
       // howManyRounds = a.HowManyRounds();
       // String nameOfType = a.TypeOfGame();


        playerList=new ArrayList<>();
       // for (int i = howManyPlayers; i > 0; i--) {
            playerList.add(a.God());
       // }
/*
        if(nameOfType == "RightAnswer"){
            type = new RightAnswer();
        }else if(nameOfType == "Bet"){
            type = new Bet();
        }
*/
    }

    public void PlayTheGame(){
        while(howManyRounds > 0){



// Edw tha ftiaxnoyme to antikeimeno Round to opoio tha trexei to paixnidi, tha pethainei kai tha dhmiourgeitai
// ena kainourgio antikeimeno mexri na teleiwsei to howManyRounds



            howManyRounds--;
        }
    }




}
