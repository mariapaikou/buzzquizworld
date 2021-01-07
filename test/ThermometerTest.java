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
        player1.setNickname("maxa");
        player2.setNickname("bool");
        array = new ArrayList<>();
        thermometer = new Thermometer();

    }

    @Test //ok!
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


    //  TODO KAINOYRIA CHANGEPOINTS GIA TIS YPOLOIPES PERIPTWSEIS!!

    @Test //ok!
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



    @Test //ok!
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

    @Test //ok!
    void setPlayersList(){

        assertFalse(thermometer.setPlayersList(array));
        array.add(player2);
        assertFalse(thermometer.setPlayersList(array));
        array.add(player1);
        assertTrue(thermometer.setPlayersList(array));

    }


    @Test
    void getName() {
        assertEquals("Thermometer",thermometer.getName());
    }
}