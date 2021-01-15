import java.util.ArrayList;

/**
 * Thermometer extends Type, and it stores the information needed for scoring this type of round. The first player to
 * answer five questions correctly wins 5000 points.
 */

public class Thermometer extends Type {

    private final int points;

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
    private void defaultifyStreaks(){
        for (Player player : players){
            player.defaultifyStreak();
        }
    }

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
