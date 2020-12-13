/**
 * This class extends Type and  adds 1000 points to every player that answers correctly.
 */

public class RightAnswer extends Type{

    int points;
    public RightAnswer(){
        super();
        points = 1000;
    }

/*
    public  RightAnswer(ArrayList<Player> players){
        super(players);
        points = 1000;
    }
     public void setPoints(int points){

        points = 1000;
    }

 */

    /**
     * Function changePoints checks for winners in the current round and increases their points by 1000 by
     * checking if their status is true.
     */
    @Override
    public void changePoints(){

        for(Player a : players){

            if(a.getStatus()){
                a.increaseScoreBy(points);
            }

        }

    }

    public String getName(){
        return "RightAnswer";
    }

}
