import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;



class TypeTest {

    private final Bet bet;
    private final RightAnswer rightAnswer;
    private final StopTheTimer stopTheTimer;
    private final QuickAnswer quickAnswer;
    private final Thermometer thermometer;
    private final ArrayList<Player> array;


     public TypeTest() {

         Player player1 = new Player();
         Player player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);
        bet = new Bet();
        rightAnswer = new RightAnswer();
        stopTheTimer = new StopTheTimer();
        quickAnswer = new QuickAnswer();
        thermometer = new Thermometer();

    }

    @Test
    void changePoints() {
         //this test if performed for every Type of game individually
    }

    @Test
    void setPlayersList() {

        ArrayList<Player> players = new ArrayList<>();

        assertTrue(bet.setPlayersList(array));

        assertTrue(rightAnswer.setPlayersList(array));

        assertTrue(stopTheTimer.setPlayersList(array));

        assertTrue(thermometer.setPlayersList(array));

        assertTrue(quickAnswer.setPlayersList(array));

        assertFalse(bet.setPlayersList(players));

    }



    @Test //ok!
    void getName() {

        assertEquals("Bet", bet.getName());

        assertEquals("RightAnswer", rightAnswer.getName());

        assertEquals("StopTheTimer", stopTheTimer.getName());

        assertEquals("Thermometer",thermometer.getName());

        assertEquals("QuickAnswer", quickAnswer.getName());

    }

   @Test
    void getExplanation(){
         assertEquals("The question category appears first. The player can bet 250, 500, 750 and 1000 points. Then the question appears and if he answers correctly he gains the points he bet, otherwise he loses them.",bet.getExplanation());
         assertEquals("The first player to answer correctly earns 1000 points and the second player 500 points",quickAnswer.getExplanation());
         assertEquals("Each player who answers correctly earns 1000 points.", rightAnswer.getExplanation());
         assertEquals("There is a timer that counts down 10 seconds and each player who answers correctly earns as many points as the milliseconds left when he answered, multiplied by 0.2." , stopTheTimer.getExplanation());
         assertEquals("The first player to answer 5 questions correctly earns 5000 points.", thermometer.getExplanation());
   }
}