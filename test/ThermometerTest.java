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
        array.add(player1);
        array.add(player2);
        thermometer = new Thermometer();


    }

    @Test
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(true);
        thermometer.setPlayersList(array);
        thermometer.changePoints();

        assertEquals(1,player1.getWallet().getStreak());
        assertEquals(1,player2.getWallet().getStreak());

        assertEquals(0,player1.getScore());
        assertEquals(0,player2.getScore());


        for(int i= 0; i<3;i++){
            thermometer.changePoints();
        }

        assertEquals(4,player1.getWallet().getStreak());
        assertEquals(4,player2.getWallet().getStreak());

        player1.getWallet().setClickTime(90);
        player2.getWallet().setClickTime(100);
        thermometer.changePoints();

        assertEquals(0,player1.getWallet().getStreak());
        assertEquals(0,player2.getWallet().getStreak());

        assertEquals(5000,player1.getScore());
        assertEquals(0,player2.getScore());
    }

    @Test
    void changePoints2(){

        thermometer.setPlayersList(array);
        player1.getWallet().setClickTime(500);
        player2.getWallet().setClickTime(10);
        player1.setStatus(true);
        player2.setStatus(true);

        for(int i = 0; i<=3; i++){
            thermometer.changePoints();

        }
        assertEquals(4,player1.getWallet().getStreak());

        player2.setStatus(false);
        thermometer.changePoints();

        assertEquals(0,player1.getWallet().getStreak());

        assertEquals(5000,player1.getScore());
        assertEquals(0,player2.getScore());

    }

    @Test
    void defaultifyStreaks(){
        player1.getWallet().increaseStreak();

        player1.setStatus(true);
        player2.setStatus(true);


        thermometer.setPlayersList(array);
        thermometer.changePoints();

        assertEquals(2,player1.getWallet().getStreak());
        assertEquals(1,player2.getWallet().getStreak());

        player1.getWallet().increaseStreak();
        player1.getWallet().increaseStreak();

        thermometer.changePoints();
        assertEquals(0,player1.getWallet().getStreak());
        assertEquals(0,player2.getWallet().getStreak());



    }

    @Test
    void getName() {
        assertEquals("Thermometer",thermometer.getName());
    }
}