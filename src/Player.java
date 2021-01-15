import java.io.Serializable;

/**
 * This class represents a player and it stores necessary information about their identity, answers and overall actions
 * when playing the game.
 */


public class Player implements Serializable {

    private String nickname;
    private int score;
    private boolean status;
    private PlayersWallet wallet;

    /**
     * Creates a player with the given string and initializes all the variables that will be needed in the course of the
     * game.
     * @param nickname the String given to be set as a nickname
     */
    public Player(String nickname){
        this.nickname = nickname;
        score = 0;
        status = false;
        wallet = new PlayersWallet();
    }

    /**
     * Constructor with no given variable for damage control, it initializes the variables.
     */
    public Player(){
        this.nickname="Randall Stephens!";
        score = 0;
        status = false;
        wallet = new PlayersWallet();
    }

    public void setNickname(String nickname) {
        if(!nickname.equals("")){
            this.nickname = nickname;
        }

    }
    public String getNickname(){
        return this.nickname;
    }

    public int getScore(){
        return this.score;
    }

    public void setStatus(boolean status){ this.status = status; }
    public boolean getStatus(){
        return status;
    }

    public PlayersWallet getWallet(){return wallet;}

    /**
     * Increases the score of the player by a given amount of new points.
     * @param newPoints an amount of points received
     */
    public void increaseScoreBy(int newPoints){
        this.score+=newPoints;
    }

    /**
     * The player's status is initialized to false.
     */
    public void defaultifyStatus(){this.status=false;}



}
