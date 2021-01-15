import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayersWalletTest {
    Player player;

    public PlayersWalletTest(){
        player = new Player();
    }
    @Test
    void setClickTime() {
        player.getWallet().setClickTime(10);
        assertEquals(10, player.getWallet().getClickTime());
    }

    @Test
    void getClickTime() {
        assertEquals(-1,player.getWallet().getClickTime());
    }

    @Test
    void setBet() {
        player.getWallet().setBet(500);
        assertEquals(500,player.getWallet().getBet());
    }

    @Test
    void getBet() {
        assertEquals(0,player.getWallet().getBet());
    }

    @Test
    void getStreak() {
        assertEquals(0,player.getWallet().getStreak());
    }

    @Test
    void increaseStreak() {
        player.getWallet().increaseStreak();
        assertEquals(1,player.getWallet().getStreak());
    }

    @Test
    void defaultifyStreak() {
        player.getWallet().increaseStreak();
        player.getWallet().defaultifyStreak();
        assertEquals(0,player.getWallet().getStreak());
    }

    @Test
    void defaultifyBet() {
        player.getWallet().setBet(1000);
        player.getWallet().defaultifyBet();
        assertEquals(0,player.getWallet().getBet());
    }
}