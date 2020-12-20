/**
 * Bet is a class that extends the Type class, it adds a new variable named betPoints and
 * is used to change the points correctly for this type of game. This game is played by
 * betting an amount before answering, if the answer is correct then the bet is added to the score
 * else it is subtracted.
 */
public class Bet extends Type {
    /**
     * @value betPoints is a integer array that is used to store the points that each player bets.
     * @value position is an integer variable that makes sure that the points bet by a user will be stored in the
     * correct order.
     */
    private final int [] betPoints;
    //private static  int[] betOptions = {250, 500, 750, 1000};
    private int position;

    public Bet(){


        super();
        betPoints = new int[2];
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
    @Override
    public void changePoints(){

        for(int i = 0 ; i < position; i++){
            if(players.get(i).getStatus()){
                players.get(i).increaseScoreBy(betPoints[i]);
            }else if( !players.get(i).getStatus() && (players.get(i).getScore() - betPoints[i]) >= 0){
                players.get(i).increaseScoreBy(-betPoints[i]);
            }else{
               players.get(i).setScore(0);
            }
        }
    }

    /**
     * setPoints is a void function that accepts an integer variable which contains the points bet
     * and adds it to the betPoints array. Then it increases the position by 1.
     */
    public void setPoints(int betPoints){
        //TODO h sygkrish na ginei mia metablhth boolean gia apolopoihsh if
        if((betPoints == 250 || betPoints == 500 || betPoints == 750 || betPoints == 1000) && position <= 1){
            this.betPoints[position]= betPoints;
            position++;
        }else{
            //TODO pws xeirizomai to else se authn thn periptwsh? xreiazetai na exv print message?
            System.out.println("error in setPoints!!!!!!!!!");
        }

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
