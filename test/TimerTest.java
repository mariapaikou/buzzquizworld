import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private final Player player1;
    private final Player player2;
    private final ArrayList<Player> players;
    private final Timer timer;


    public TimerTest(){

        player1 = new Player();
        player2 = new Player();
        players = new ArrayList<>();
        timer = new Timer();


    }

    @Test //ok!
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(false);

        players.add(player1);
        players.add(player2);

        player1.setClickTime(1000);
        player2.setClickTime(500);


        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(200, player1.getScore());
        assertEquals(0, player2.getScore());

    }

    @Test //ok!
    void changePoints2() {
        player1.setStatus(false);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);



        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }

    @Test //ok!
    void changePoints3() {
        player1.setStatus(true);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);

        player1.setClickTime(3000);
        player2.setClickTime(1000);

        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(600, player1.getScore());
        assertEquals(200, player2.getScore());
    }

    @Test
    void getName() {
        assertEquals("Timer", timer.getName());
    }
}