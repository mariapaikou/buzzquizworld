public class Bet extends Type {
    int betPoints;

    public Bet(){
        betPoints=0;
    }


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

    public boolean setPoints(int betPoints){

        if(betPoints == 250 || betPoints == 500 || betPoints == 750 || betPoints == 1000){
            this.betPoints=betPoints;
            return true;
        }else{
            return false;
        }
    }



}
