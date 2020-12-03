import java.util.ArrayList;

/**
 * This class is initializing the players of the game also it makes a new round object.
 */

public class Game {
    /**
     * @param playerList is an ArrayList that stores Player objects
     * @param randomQuestions is an Arraylist that stores the three Questions objects that are
     *                        randomly selected by a Round method.
     */
    //private int howManyPlayers;
    private ArrayList <Player> playerList;
    private ArrayList<Questions> randomQuestions;
    private static int howManyRounds = 5;
    private UserInteraction display;


/**
 * Constructor
 */
    public Game(){

        display = new UserInteraction();
       // howManyPlayers = a.HowManyOfYou();
       // howManyRounds = a.HowManyRounds();

        playerList = new ArrayList<>();
       // for (int i = howManyPlayers; i > 0; i--) {
            playerList.add(display.God());
       // }

        randomQuestions = new ArrayList<>();
    }


    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Function PlayTheGame
     */
    public void PlayTheGame(){
        while(howManyRounds > 0){

        Round round = new Round();
        Type type = round.getRandomType();
        type.SetPlayersList(playerList);

            howManyRounds--;
        }
    }

    public static void main(String [] args){
        Game b = new Game();
        b.PlayTheGame();
        System.out.println("the end!!");
    }


}
