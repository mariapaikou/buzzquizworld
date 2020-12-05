import java.util.ArrayList;

/**
 * This class adds 1000 points to every player that answers correctly.
 * It will receive the list with the players that answered correctly and it will add the points
 */

public class RightAnswer extends Type{

    public RightAnswer(){
        super();
    }

    public  RightAnswer(ArrayList<Player> players){
       super(players);
    }

    /**
     * Function changePoints checks for winners in the current round and increases their points by 1000
     */
    @Override
    public void changePoints(){
        for(Player a : players){
            if(a.getStatus()){
                a.increaseScoreBy(1000);
            }
        }
    }


    public String getName(){
        return "RightAnswer";
    }

}
