import java.util.ArrayList;

public class QuickAnswer extends Type {

    int points;

    public QuickAnswer(){
        super();
        points = 500;
    }

    /**
     * ChangePoints checks the players ArrayList and increases the points of the first player who answers
     * correctly by 1000. For every other player that answered correctly the function adds to the players score
     * 500 points.
     */
    public void changePoints(){
        ArrayList<Player> correctMan = new ArrayList<>();

        for(Player player : players){

            if(player.getStatus()){
                correctMan.add(player);
                player.increaseScoreBy(points);
            }
        }

        int min = 999999999;
        for(int i = 0 ; i < correctMan.size(); i++){
            if(correctMan.get(i).getClickTime() < min){
                min = i;
            }
        }
        if(!(min == 999999999)){
            correctMan.get(min).increaseScoreBy(points);
        }

        defaultifyClickTime();
    }

    /**
     * Sets each player's clickTime back to zero.
     */
    private void defaultifyClickTime(){
        for(Player player : players){
            player.setClickTime(0);
        }
    }

    /**
     * @return the name of the class in the form of a String.
     */
    public String getName(){return "QuickAnswer";}

    /**
     * @return a String with a brief explanation of this type of round.
     */
    public String getExplanation(){
        return "The first player to answer correctly earns 1000 points and the second player 500 points";
    }

}
