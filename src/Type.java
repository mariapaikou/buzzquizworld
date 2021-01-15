import java.util.ArrayList;

/**
 * Type class is and abstract class that represents the type of games.
 *
 */
public abstract class Type {

    protected ArrayList<Player> players;

    /**
     * Constructor
     */
    public Type() {

        this.players = new ArrayList<>();

    }

    /**
     * Abstract method changePoints changes the points of the players.
     */
    public abstract void changePoints();

    /**
     * Abstract method getName returns the name of the type of game
     * @return String
     */
    public abstract String getName();


    /**
     * Method setPlayerList accepts an arrayList of players. If the arrayList is saved correctly returns true, else
     * returns false.
     * @param players the arrayList of players
     * @return boolean
     */
    public boolean setPlayersList(ArrayList<Player> players) {

        if(players.size() != 0){
            this.players = players;
        }

        return this.players == players;

    }

    /**
     * Abstract method getExplanation returns the instructions for the type of game.
     * @return String
     */
    public abstract String getExplanation();

}