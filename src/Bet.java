public class Bet extends Type {
    int betPoints;


    public Bet(){
        betPoints=0;
    }

    private void changePoints(int pointsBetted){
        for(Player a: players){
            if(a.getStatus() == 1){
                a.setScore(pointsBetted);
            }else if(a.getStatus() == 0){
                a.setScore(-pointsBetted);
            }
        }
    }
}
