import java.io.Serializable;

/**
 * This class represents a player and it stores necessary information about their identity, answers and overall actions
 * when playing the game.
 */


public class Player implements Serializable {
    /**
     * Each player has a:
     * score: is the sum of the player's points
     * status: depending on the players answer is either true or false (correct, not correct)
     * clickTime:  stores the milliseconds from the moment the question appears until the player answers
     * bet: is used when playing Bet and stores the amount that the player bet
     * myThread: is used to make the player class serializable in order to be able to store a player object in a file
     * streak: is used in the Thermometer round and stores the number of correct questions answered.
     */

    private String nickname;
    private int score;
    private boolean status;
    private long clickTime;
    private int bet;
    transient private Thread myThread;
    private int streak;

    /**
     * Creates a player with the given string and initializes all the variables that will be needed in the course of the
     * game.
     * @param nickname the String given to be set as a nickname
     */
    public Player(String nickname){
        this.nickname = nickname;
        score = 0;
        status = false;
        clickTime = -1;
        this.myThread = new Thread();
        bet = 0;
        streak = 0;
    }



    /**
     * Constructor with no given variable for damage control, it initializes the variables.
     */
    public Player(){
        this.nickname="Randall Stephens!";
        score = 0;
        status = false;
        bet = 0;
        streak = 0;
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

    public void setClickTime(long time){this.clickTime = time;}
    public long getClickTime(){return clickTime;}

    public void setBet(int bet){this.bet = bet;}
    public int getBet(){return bet;}

    public int getStreak(){return streak;}

    /**
     * This method increases the players streak by one.
     */
    public void increaseStreak(){
        streak++;
    }

    /**
     * Returns the streak to its default value, which is zero.
     */
    public void defaultifyStreak(){streak = 0;}

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

    /**
     * The player's bet is initialized to zero.
     */
    public void defaultifyBet(){setBet(0);}

}
