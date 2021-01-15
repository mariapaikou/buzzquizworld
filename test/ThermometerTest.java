import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class ThermometerTest {

    private final Player player1;
    private final Player player2;
    private final ArrayList<Player> array;
    private final Thermometer thermometer;


    public ThermometerTest(){

        player1 = new Player();
        player2 = new Player();
        player1.setNickname("Tom");
        player2.setNickname("Jerry");
        array = new ArrayList<>();
        thermometer = new Thermometer();

    }

    @Test
    void changePoints() {

        player1.setClickTime(500);
        player2.setClickTime(10000);

        array.add(player1);
        array.add(player2);
        thermometer.setPlayersList(array);

        for(int i=0; i<6; i++){
            player1.setStatus(true);
            player2.setStatus(true);
            thermometer.changePoints();

        }

        assertEquals(5000,player1.getScore());
        assertEquals(0,player2.getScore());

        for(int i=0; i<6; i++){
            player1.setStatus(true);
            player2.setStatus(true);
            thermometer.changePoints();

        }

        assertEquals(10000,player1.getScore());
        assertEquals(0,player2.getScore());
    }

    @Test
    void changePoints2(){

        array.add(player1);
        array.add(player2);
        thermometer.setPlayersList(array);
        player1.setClickTime(500);
        player2.setClickTime(1000);

        for(int i = 0; i<= 3; i++){
            player1.setStatus(true);
            player2.setStatus(true);
            thermometer.changePoints();

        }


            player2.setStatus(true);
            thermometer.changePoints();


        assertEquals(0,player1.getScore());
        assertEquals(5000,player2.getScore());

        for(int i = 0; i<= 3; i++){
            player1.setStatus(true);
            player2.setStatus(true);
            thermometer.changePoints();

        }

            player2.setStatus(true);
            thermometer.changePoints();

        assertEquals(0,player1.getScore());
        assertEquals(10000,player2.getScore());

    }

    @Test
    void changePoints3(){
        array.add(player1);
        array.add(player2);

        player1.setClickTime(6000);
        player2.setClickTime(5);

        thermometer.setPlayersList(array);


        for(int i = 0 ; i<10 ;i++){
            thermometer.changePoints();
        }

        assertEquals(0,player1.getScore());
        assertEquals(0,player2.getScore());

    }

    @Test
    void defaultifyStreaks(){
        player1.increaseStreak();

        player1.setStatus(true);
        player2.setStatus(true);

        array.add(player1);
        array.add(player2);

        thermometer.changePoints();

        assertEquals(2,player1.getStreak());
        assertEquals(1,player2.getStreak());

        thermometer.changePoints();

        assertEquals(0,player1.getStreak());
        assertEquals(0,player2.getStreak());

    }

    @Test
    void getName() {
        assertEquals("Thermometer",thermometer.getName());
    }
}