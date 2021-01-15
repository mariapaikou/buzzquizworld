/**
 * StopTheTimer class extends Type class and represent the stop the timer type of game.
 * In this type of game there is a timer that counts 10 seconds. Every player that answers correctly to the question
 * gets point equal to the milliseconds left before the 10 seconds pass multiplied by 0,2.
 */
public class StopTheTimer extends Type {

    public StopTheTimer(){
        super();
    }

    /**
     * Method changePoints increases the score for every player that answered correctly according to the time left
     * after the player answers the question and before the 10 seconds pass.
     */
    public void changePoints() {

        for (Player player : players) {

            if (player.getStatus()) {

                long timeLeft = player.getWallet().getClickTime();
                if (timeLeft != -1) {
                    player.increaseScoreBy((int) ( timeLeft * 0.2));
                }

            }
        }

    }

    /**
     * Method getName returns a string that contains the name of the game.
     * @return String
     */
    public String getName(){return "StopTheTimer";}

    /**
     * Method getExplanation returns a string that contains the instructions for the StopTheTime game.
     * @return String
     */
    public String getExplanation(){
        return "There is a timer that counts down 10 seconds and each player who answers correctly earns as many" +
                " points as the milliseconds left when he answered, multiplied by 0.2.";
    }
}

