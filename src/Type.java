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

        if(this.players == players){
            return true;
        }else{
            return false;
        }

    }

    protected void defaultfyPlayers(){

        for (Player player : players){

            player.setStatus(false);
            if(player.getClickTime() > -1){

                player.setClickTime(-1);
            }
        }
    }

}