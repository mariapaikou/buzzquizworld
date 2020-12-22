import java.util.ArrayList;

public class QuickAnswer extends Type {
//TODO na ta baloume se array gia an sto mellon theloume perissoterous paiktes kai allous ba8mous
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

        boolean firstToAnswerCorrectly = true;

        for(int i = 0; i<players.size(); i++){

            if( firstToAnswerCorrectly && players.get(i).getStatus()){

                players.get(i).increaseScoreBy(firstsPoints);
                firstToAnswerCorrectly = false;

            }else if(players.get(i).getStatus()){

                players.get(i).increaseScoreBy(secondsPoints);

            }

        }

    }

    public String getName(){return "QuickAnswer";}




}
