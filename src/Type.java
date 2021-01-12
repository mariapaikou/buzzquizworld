import java.util.ArrayList;

/**
 * This class is the parent of the game types that are available.
 * It has an ArrayList that stores the players.
 */

public abstract class Type {

    protected ArrayList<Player> players;


    public Type() {

        this.players = new ArrayList<>();

    }
/*
    public Type(ArrayList<Player> players) {
        this.players = players;
    }
 */

    public abstract void changePoints();

    public abstract String getName();

    public boolean setPlayersList(ArrayList<Player> players) {

        if(players.size() != 0){
            this.players = players;
        }

        return this.players == players;

    }


    public abstract String getExplanation();

}