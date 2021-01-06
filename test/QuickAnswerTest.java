import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuickAnswerTest {
    private Player player1;
    private Player player2;
    private ArrayList<Player> array;
    private QuickAnswer quickAnswer;

    public QuickAnswerTest(){
        player1 = new Player();
        player2 = new Player();
        array = new ArrayList<>();
        quickAnswer = new QuickAnswer();
    }

    @Test //ok!
    void changePoints() {
        player1.setStatus(true);
        player2.setStatus(true);

        player1.setTime(500);
        player2.setTime(1000);


        array.add(player1);
        array.add(player2);

        quickAnswer.setPlayersList(array);
        quickAnswer.changePoints();

        assertEquals(1000,player1.getScore());
        assertEquals(500,player2.getScore());


    }

    @Test //ok!
    void changePoints2(){
        player1.setStatus(false);
        player2.setStatus(true);

        player1.setTime(500);
        player2.setTime(1000);

        array.add(player1);
        array.add(player2);

        quickAnswer.setPlayersList(array);
        quickAnswer.changePoints();


        assertEquals(0,player1.getScore());
        assertEquals(1000,player2.getScore());
    }

    @Test //ok!
    void changePoints3(){
        player1.setStatus(false);
        player2.setStatus(false);

        player1.setTime(50);
        player2.setTime(50);

        array.add(player1);
        array.add(player2);

        quickAnswer.setPlayersList(array);
        quickAnswer.changePoints();


        assertEquals(0,player1.getScore());
        assertEquals(0,player2.getScore());
    }


    @Test //ok!
    void getName() {
        assertEquals("QuickAnswer",quickAnswer.getName());
    }
}