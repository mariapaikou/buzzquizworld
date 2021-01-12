/**
 * Bet is a class that extends the Type class, it adds a new variable named betPoints and
 * is used to change the points correctly for this type of game. This game is played by
 * betting an amount before answering, if the answer is correct then the bet is added to the score
 * else it is subtracted.
 */
public class Bet extends Type {
    /**
     *
     */
    public Bet(){
        super();

    }



    /**
     * Function changePoints, adds or removes the bet points from the player's score depending on whether he has answered
     * the question correctly or not. This can be determined by checking the status variable.
     */
    @Override
    public void changePoints(){

        for(Player player : players){
            if(player.getStatus()){
                player.increaseScoreBy(player.getBet());
            }else if( !player.getStatus() ) {
                player.increaseScoreBy(-player.getBet());
            }
        }

    }

    /**
     *
     * @return
     */
    public String getName(){
        return "Bet";
    }

    /**
     *
     * @return
     */
    public String getExplanation(){
        String explanation = "The question category appears first. The player can bet 250, 500, 750 and 1000 points. Then the question appears and if he answers correctly he gains the points he bet, otherwise he loses them.";
        return explanation;
    }

}
