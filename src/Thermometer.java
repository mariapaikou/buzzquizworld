import java.util.ArrayList;

/**
 * Thermometer extends Type, and it stores the information needed for scoring this type of round. The first player to
 * answer five questions correctly wins 5000 points.
 */

public class Thermometer extends Type {

    private final int points;
    private boolean someoneWon = false;

    public Thermometer(){

        super();
        points = 5000;

    }

    /**
     * ChangePoints increases the streak for every player that answered correctly until at least one of them gets a
     * streak of five correct answers. The first one to reach a streak of five has their score increased by 5000.
     */
    public void changePoints(){

        ArrayList<Player> reachedFive = new ArrayList<>();
        for (Player player : players) {
            if (player.getStatus()) {
                player.increaseStreak();
            }
            if (player.getStreak() == 5) {
                reachedFive.add(player);
            }
        }

        if (reachedFive.size() == 1){
            reachedFive.get(0).increaseScoreBy(points);
            defaultifyStreaks();
        }else if(reachedFive.size() == 2) {
            if (reachedFive.get(0).getClickTime() < reachedFive.get(1).getClickTime()) {
                reachedFive.get(0).increaseScoreBy(points);
            } else {
                reachedFive.get(1).increaseScoreBy(points);
            }
            defaultifyStreaks();
        }

    }

    /**
     * Goes through the list of the players and sets their streak to default.
     */
    public void defaultifyStreaks(){
        for (Player player : players){
            player.defaultifyStreak();
        }
        someoneWon = true;
    }

    /**
     * @return a boolean variable that returns if the game should end or not.
     */
    public boolean getSomeoneWon(){return someoneWon;}

    /**
     * Sets the variable back to false because the round ended.
     */
    public void initializeSomeoneWon(){someoneWon = false;}

    /**
     * @return the name of the class in the form of a String.
     */
    public String getName(){return "Thermometer";}

    /**
     * @return a String with a brief explanation of this type of round.
     */
    public String getExplanation(){
        return "The first player to answer 5 questions correctly earns 5000 points.";
    }
}
