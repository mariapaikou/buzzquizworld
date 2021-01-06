import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;



class TypeTest {

    private final Bet bet;
    private final RightAnswer rightAnswer;
    private final Timer timer;
    private final QuickAnswer quickAnswer;
    private final Thermometer thermometer;
    private final Player player1;
    private final Player player2;
    private ArrayList<Player> array;


     public TypeTest() {

        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        array.add(player1);
        array.add(player2);
        bet = new Bet();
        rightAnswer = new RightAnswer();
        timer = new Timer();
        quickAnswer = new QuickAnswer();
        thermometer = new Thermometer();

    }

    @Test
    void changePoints() {

         //aythn thn tsekaroume ksexvrista gia kathe upoklash!

    }

    @Test
    void setPlayersList() {

        ArrayList<Player> players = new ArrayList<>();

        assertEquals(true,bet.setPlayersList(array));

        assertEquals(true,rightAnswer.setPlayersList(array));

        assertEquals(true,timer.setPlayersList(array));

        assertEquals(true,thermometer.setPlayersList(array));

        assertEquals(true,quickAnswer.setPlayersList(array));

        assertEquals(false,bet.setPlayersList(players));

    }



    @Test //ok!
    void getName() {

        assertEquals("Bet", bet.getName());

        assertEquals("RightAnswer", rightAnswer.getName());

        assertEquals("Timer", timer.getName());

        assertEquals("Thermometer",thermometer.getName());

        assertEquals("QuickAnswer", quickAnswer.getName());

    }

    @Test //ok!
    void defaultfyPlayers(){
         player1.setStatus(true);
         player2.setStatus(true);

         bet.setPlayersList(array);
         bet.defaultfyPlayers();

         assertEquals(false,player1.getStatus());
         assertEquals(false,player2.getStatus());
    }

    @Test //ok!
    void defaultfyPlayers2(){
         player1.setClickTime(500);
         player2.setClickTime(600);

         quickAnswer.setPlayersList(array);
         quickAnswer.defaultfyPlayers();

         assertEquals(-1,player1.getClickTime());
         assertEquals(-1,player2.getClickTime());

    }
}