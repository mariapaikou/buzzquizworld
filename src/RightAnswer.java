/**
 * This class extends Type and adds 1000 points to every player that answers correctly.
 */

public class RightAnswer extends Type{

    int points;

    public RightAnswer(){
        super();
        points = 1000;
    }

    /**
     * Function changePoints checks for winners after each question and increases their points by 1000 by checking
     * if their status is true.
     */
    @Override
    public void changePoints(){

        for(Player a : players){

            if(a.getStatus()){
                a.increaseScoreBy(points);
            }
        }
    }

    /**
     * @return the name of the class in the form of a String.
     */
    public String getName(){
        return "RightAnswer";
    }

    /**
     * @return a String with a brief explanation of this type of round.
     */
    public String getExplanation(){
        return "Each player who answers correctly earns 1000 points.";
    }

}
