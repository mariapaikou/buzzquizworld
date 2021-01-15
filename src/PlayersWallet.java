/**
 * This class represents a players wallet, it contains variables and methods that are used
 * in special type of rounds.
 */
public class PlayersWallet {
    private long clickTime;
    private int bet;
    private int streak;

    public PlayersWallet(){
        clickTime = -1;
        bet = 0;
        streak = 0;
    }

    public void setClickTime(long time){this.clickTime = time;}
    public long getClickTime(){return clickTime;}

    public void setBet(int bet){this.bet = bet;}
    public int getBet(){return bet;}

    public int getStreak(){return streak;}

    /**
     * This method increases the streak by one.
     */
    public void increaseStreak(){
        streak++;
    }

    /**
     * Returns the streak to its default value, which is zero.
     */
    public void defaultifyStreak(){streak = 0;}

    /**
     * The player's bet is initialized to zero.
     */
    public void defaultifyBet(){setBet(0);}
}
