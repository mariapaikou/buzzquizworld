import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StopTheTimerTest {
    private final Player player1;
    private final Player player2;
    private final ArrayList<Player> players;
    private final StopTheTimer stopTheTimer;


    public StopTheTimerTest(){

        player1 = new Player();
        player2 = new Player();
        players = new ArrayList<>();
        stopTheTimer = new StopTheTimer();


    }

    @Test //ok!
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(false);

        players.add(player1);
        players.add(player2);

        player1.getWallet().setClickTime(1000);
        player2.getWallet().setClickTime(500);


        stopTheTimer.setPlayersList(players);
        stopTheTimer.changePoints();

        assertEquals(200, player1.getScore());
        assertEquals(0, player2.getScore());

    }

    @Test //ok!
    void changePoints2() {
        player1.setStatus(false);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);



        stopTheTimer.setPlayersList(players);
        stopTheTimer.changePoints();

        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }

    @Test //ok!
    void changePoints3() {
        player1.setStatus(true);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);

        player1.getWallet().setClickTime(3000);
        player2.getWallet().setClickTime(1000);

        stopTheTimer.setPlayersList(players);
        stopTheTimer.changePoints();

        assertEquals(600, player1.getScore());
        assertEquals(200, player2.getScore());
    }

    @Test
    void getName() {
        assertEquals("StopTheTimer", stopTheTimer.getName());
    }
}