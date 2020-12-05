import java.util.ArrayList;

/**
 * This class is the parent of the game types that are available.
 * It has an int that refers to the points that need to be added to the winner and it also has
 * a variable to save the winner of the round.
 */

public abstract class Type {
    protected ArrayList<Player> players;

    public Type(){
        this.players = new ArrayList<>();

    }
/*
    public Type(ArrayList<Player> players) {
        this.players = players;
    }
 */


    public abstract void  changePoints();
    public abstract String getName();
    // public abstract void setPoints(int points);

    public void SetPlayersList(ArrayList<Player> players){
        this.players = players;
    }


}
