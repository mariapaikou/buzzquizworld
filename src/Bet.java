/**
 * Bet is a class that extends the Type class, it adds a new variable named betPoints and
 * is used to change the points correctly for this type of game. This game is played by
 * betting an amount before answering, if the answer is correct then the bet is added to the score
 * else it is subtracted.
 */
public class Bet extends Type {

    public Bet(){
        super();
    }

    /**
     * Method changePoints, adds or removes the bet points from the player's score depending on whether he has answered
     * the question correctly or not. This can be determined by checking their status.
     */
    @Override
    public void changePoints(){

        for(Player player : players){
            if(player.getStatus()){
                player.increaseScoreBy(player.getWallet().getBet());
            }else if( !player.getStatus() ) {
                player.increaseScoreBy(-player.getWallet().getBet());
            }
        }

    }

    /**
     * @return the name of the class in the form of a String.
     */
    public String getName(){
        return "Bet";
    }

    /**
     * @return a String with a brief explanation of this type of round.
     */
    public String getExplanation(){
        return "The question category appears first. The player can bet 250, 500, 750 and 1000 points. Then the question appears and if he answers correctly he gains the points he bet, otherwise he loses them.";
    }

}
