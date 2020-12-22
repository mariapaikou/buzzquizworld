import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ThermometerTest {

    private Player player1;
    private Player player2;
    private ArrayList array;
    private Thermometer thermometer;


    public ThermometerTest(){

        player1 = new Player();
        player2 = new Player();
        array = new ArrayList();
        thermometer = new Thermometer();

    }

    @Test //ok!
    void changePoints() {

        player1.setStatus(true);
        player2.setStatus(true);
        array.add(player1);
        array.add(player2);
        thermometer.setPlayersList(array);

        for(int i=0; i<6; i++){
            thermometer.changePoints();
        }

        assertEquals(5000,player1.getScore());
        assertEquals(0,player2.getScore());
    }

    @Test
    void setPlayersList(ArrayList<Player> players){

        assertEquals(false,thermometer.setPlayersList(array));

    }


    @Test
    void getName() {
        assertEquals("Thermometer",thermometer.getName());
    }
}