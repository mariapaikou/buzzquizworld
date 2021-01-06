import java.util.ArrayList;

public class QuickAnswer extends Type {

    private final int [] points;
    private final ArrayList<Player> sortedPlayers;

    public QuickAnswer(){
        super();
        points = new int[2];
        points[0] = 1000;
        points[1] = 500;
        sortedPlayers = new ArrayList<>();

    }

    /**
     * Function changePoints checks the players ArrayList and increases the points of the first player who answers
     * correctly by 1000. For every other player that answered correctly the function adds to the players score
     * 500 points.
     *
     */
    public void changePoints(){

        for(int i = 0; i<players.size(); i++){
            int max = 99999999;
            for(int j=i; j < players.size(); j++){

                if(players.get(j).getTime() < max){

                    max = j;

                }

            }

            if(players.get(max).getStatus()){

                sortedPlayers.add(players.get(max));

            }
        }

        for (Player player : sortedPlayers) {
            if (player == sortedPlayers.get(0)) {

                player.increaseScoreBy(points[0]);

            } else  {
                player.increaseScoreBy(points[1]);

            }

        }

    }

    public String getName(){return "QuickAnswer";}




}
