public class Bet extends Type {
    int betPoints; //auto sto mellon tha ginei eite 2 metablhtes, eite kapoia domh pou tha apothhkeuei ta bet twn paiktwn

    public Bet(){
        betPoints=0;
    }

    /**
     * Function changePoints, adds or removes the bet points from the player's score depending on whether he has answered
     * correctly or not. This can be determined checking the status variable.
     */

    public void changePoints(){
        for(Player a: players){
            if(a.getStatus()){
                a.increaseScoreBy(betPoints);
            }else if(a.getStatus() && (a.getScore()-betPoints > 0)){
                a.increaseScoreBy(-betPoints);
            }else{
                a.setScore(0);
            }
        }
    }

    /**
     * setPoints is a boolean function that checks if the given bet amount is acceptable and
     * if so, sets the user's bet to that amount.
     * @param betPoints is a variable that contains the points that the user bets
     * @return If the action is successful, the function returns true. If the betPoints are a
     * not acceptable amount and therefore the action is not successful, it returns false.
     */

    public boolean setPoints(int betPoints){

        if(betPoints == 250 || betPoints == 500 || betPoints == 750 || betPoints == 1000){
            this.betPoints=betPoints;
            return true;
        }else{
            return false;
        }
    }



}
