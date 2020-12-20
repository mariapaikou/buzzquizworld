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

    @Test //ok!
    void changePoints() {

        int points = 1000;
        bet.setPoints(points);
        bet.setPoints(points);

        player1.setStatus(true);
        player2.setStatus(true);
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
        bet.setPoints(points);
        bet.setPoints(points);
        player1.setStatus(false);
        player2.setStatus(false);
        bet.changePoints();

        assertEquals(-1000,player1.getScore());
        assertEquals(-1000,player2.getScore());

    }

    @Test //ok!
    void setPoints(){

        int points = -1020;
        bet.setPoints(points); // error message
        bet.setPoints(1000);
        bet.setPoints(1000);
        bet.setPoints(1000); // error message

    }


    @Test //ok!
    void initializePositions() {

       int points = 500;
       bet.setPoints(points);
       player1.setStatus(true);
       bet.changePoints();
       bet.initializePositions();
       bet.setPoints(points);
       player1.setStatus(true);
       bet.changePoints();

       assertEquals(1000,player1.getScore());

    }

    @Test // ok!
    void getName() {

       String name = bet.getName();
       assertEquals("Bet", bet.getName());

    }


}
