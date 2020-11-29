

/**
 * This class adds 1000 points to every player that answers correctly.
 * It will receive the list with the players that answered correctly and it will add the points
 */

public class RightAnswer extends Type{

    public  RightAnswer(){

    }

    /**
     * Function addPoints checks for winners in the current round and increases there points by 1000
     */
    private void addPoints(){
        for(Player a : players){
            if(a.getStatus() == 1){
                a.increaseScoreBy(1000);
            }
        }
    }



}
