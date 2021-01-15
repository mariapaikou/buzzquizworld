import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class BetTest {
    private final Bet bet;
    private final Player player1;
    private final Player player2;
    final  ArrayList<Player> array;

    public BetTest(){

        bet = new Bet();
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);
        bet.setPlayersList(array);

    }

    @Test
    void changePoints() {

        int points = 1000;

        player1.setStatus(true);
        player2.setStatus(true);

        player1.getWallet().setBet(points);
        player2.getWallet().setBet(points);

        bet.changePoints();
        assertEquals(points,player1.getScore());


        player1.setStatus(false);
        bet.changePoints();
        assertEquals(0,player1.getScore());
        assertEquals(2000,player2.getScore());


        player1.setStatus(true);
        player2.setStatus((false));
        bet.changePoints();
        assertEquals(1000,player1.getScore());
        assertEquals(1000,player2.getScore());


    }

    @Test
    void changePoints2(){

        int points = 1000;
        player1.getWallet().setBet(points);
        player2.getWallet().setBet(points);

        player1.setStatus(false);
        player2.setStatus(false);
        bet.changePoints();

        assertEquals(-1000,player1.getScore());
        assertEquals(-1000,player2.getScore());



    }

    @Test
    void changePoints3(){

        int points1 = 500;
        int points2 = 250;

        player1.increaseScoreBy(1000);
        player2.increaseScoreBy(500);

        player1.getWallet().setBet(points1);
        player2.getWallet().setBet(points2);

        player1.setStatus(true);
        player2.setStatus(false);
        bet.changePoints();

        assertEquals(1500,player1.getScore());
        assertEquals(250,player2.getScore());

        player1.setStatus(true);
        player2.setStatus(true);
        bet.changePoints();

        assertEquals(2000,player1.getScore());
        assertEquals(500,player2.getScore());

        player1.setStatus(false);
        player2.setStatus(false);
        bet.changePoints();

        assertEquals(1500,player1.getScore());
        assertEquals(250,player2.getScore());

    }

    @Test
    void getName() {

       String name = bet.getName();
       assertEquals("Bet", bet.getName());

    }


}
