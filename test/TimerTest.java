import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {
    private Player player1;
    private Player player2;
    private ArrayList<Player> players;
    private Timer timer;
    private int[] times;

    public TimerTest(){
        player1 = new Player();
        player2 = new Player();

        players = new ArrayList<>();

        timer = new Timer();

        times = new int[2];
    }

    @Test
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(false);

        players.add(player1);
        players.add(player2);

        times[0] = 1200;
        times[1] = 2300;

        timer.setTimeLeft(times);

        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(240, player1.getScore());
        assertEquals(0, player2.getScore());

    }

    @Test
    void changePoints2() {
        player1.setStatus(false);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);

        times[0] = 2000;
        times[1] = 3000;

        timer.setTimeLeft(times);

        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(0, player1.getScore());
        assertEquals(600, player2.getScore());
    }

    @Test
    void changePoints3() {
        player1.setStatus(true);
        player2.setStatus(true);

        players.add(player1);
        players.add(player2);
        times[0] = 2500;
        times[1] = 2600;

        timer.setTimeLeft(times);

        timer.setPlayersList(players);
        timer.changePoints();

        assertEquals(500, player1.getScore());
        assertEquals(520, player2.getScore());
    }

    @Test
    void getName() {
        assertEquals("Timer", timer.getName());
    }
}