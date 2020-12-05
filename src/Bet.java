import java.util.ArrayList;

public class Bet extends Type {
    /**
     * betOptions is a static array of integers, and stores the acceptable choices for the player to bet.
     */
    private int [] betPoints; //auto sto mellon tha ginei eite 2 metablhtes, eite kapoia domh pou tha apothhkeuei ta bet twn paiktwn
    private static  int[] betOptions = {250, 500, 750, 1000};
    private int position;

    public Bet(){
        super();
        betPoints = new int[1];
        position = 0;

    }
/*
     public Bet(ArrayList<Player> players){
        super(players);
        betPoints = new int[this.players.size()];
        position = 0;
    }
 */

    /**
     * Function changePoints, adds or removes the bet points from the player's score depending on whether he has answered
     * the question correctly or not. This can be determined by checking the status variable.
     */

    public void changePoints(){

        for(int i = 0 ; i < players.size(); i++){
            if(players.get(i).getStatus()){
                players.get(i).increaseScoreBy(betPoints[i]);
            }else if( !players.get(i).getStatus() && (players.get(i).getScore() - betPoints[i]) > 0){
                players.get(i).increaseScoreBy(-betPoints[i]);
            }else{
               players.get(i).setScore(0);
            }
        }
    }

    /**
     * setPoints is a boolean function that checks if the given bet amount is acceptable and
     * if so, sets the user's bet to that amount.
     * @value betPoints is a variable that contains the points that the user bets.
     * not acceptable amount and therefore the action is not successful, it returns false.
     */

    public void setPoints(int betPoints){
        this.betPoints[position]= betPoints;
        position++;
        /*

        for(int i = 0; i < betOptions.length; i++) {
            if (betPoints == betOptions[i]) {
                this.betPoints [i] = betOptions[i];
            }
            return true;
        }
        return false;

         */
    }

    public void initializePositions(){
        position = 0;
    }

    public String getName(){
        return "Bet";
    }

}
