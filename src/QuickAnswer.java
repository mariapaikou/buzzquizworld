import java.util.ArrayList;

public class QuickAnswer extends Type {

    int firstsPoints;
    int secondsPoints;

    public QuickAnswer(){
        super();
        firstsPoints = 1000;
        secondsPoints = 500;

    }

    /**
     * Function changePoints checks the players ArrayList and increases the points of the first player who answers
     * correctly by 1000. For every other player that answered correctly the function adds to the players score
     * 500 points.
     *
     */
    public void changePoints(){
        System.out.println("");
        boolean firstToAnswerCorrectly = true;

        for(int i = 0; i<players.size(); i++){

            if( firstToAnswerCorrectly && players.get(i).getStatus()){
                //System.out.println("inside first if!");
                players.get(i).increaseScoreBy(firstsPoints);
                firstToAnswerCorrectly = false;

            }else if(players.get(i).getStatus()){

                players.get(i).increaseScoreBy(secondsPoints);

            }

        }

    }

    public String getName(){return "QuickAnswer";}




}
